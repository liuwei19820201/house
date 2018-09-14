package com.jzfq.house.service;

import com.jzfq.house.exception.BadRequestException;
import com.jzfq.house.mybatis.domain.SysArea;
import com.jzfq.house.mybatis.domain.SysAreaDTO;
import com.jzfq.house.mybatis.domain.SysAreaQuery;
import com.jzfq.house.mybatis.service.SysAreaService;
import com.jzfq.house.redis.RedisService;
import com.jzfq.house.util.JsonMapper;
import com.jzfq.house.util.TransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class SysAreaManage extends BaseManage<Long>{
    @Autowired
    SysAreaService<SysArea, SysAreaQuery, Long> service;
    @Autowired
    RedisService redisService;

    @Override
    public SysAreaService<SysArea, SysAreaQuery, Long> getService() {
        return service;
    }

    public boolean save(SysArea sysArea){
        int i = getService().save(sysArea);
        if(i == 1){
            SysArea child = getByParentIdAndLabel(sysArea.getParentId(), sysArea.getLabel());
            SysArea parent = findById(sysArea.getParentId());
            String fullPath = (parent.getFullPath()==null?"":parent.getFullPath()) + "/" + child.getId();
            String fullName = (parent.getFullName()==null?"":parent.getFullName()) + "/" + child.getLabel();
            int level = parent.getLevel() + 1;
            child.setFullPath(fullPath);
            child.setFullName(fullName);
            child.setLevel(level);
            getService().updateByKey(child);
            // 更新缓存
            refreshTreeRedis();
            return true;
        }else{
            return false;
        }
    }

    public int updateMulti(List<SysArea> sysAreaList){
        int count = 0;
        for(SysArea sysArea : sysAreaList){
            count = count + update(sysArea);
        }
        // 更新缓存
        refreshTreeRedis();
        return count;
    }

    public int deleteMulti(String ids){
        int count = 0;
        for(String idStr : ids.split(",")){
            count = count + delete(Long.parseLong(idStr));
        }
        // 更新缓存
        refreshTreeRedis();
        return count;
    }

    public List<Map<String, Object>> getOptionsByParentId(Long parentId){
        String sql = "select id as value, label from sys_area where parent_id = " + parentId;
        List<Map<String, Object>> bySQL = getService().findBySQL(sql);
        return bySQL;
    }

    public SysArea getByParentIdAndLabel(Long parentId, String label){
        SysAreaQuery query = new SysAreaQuery();
        SysAreaQuery.Criteria criteria = query.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        criteria.andLabelEqualTo(label);
        List<SysArea> sysAreaList = getService().findBy(query);
        if(sysAreaList == null || sysAreaList.size() == 0){
            return null;
        }
        return sysAreaList.get(0);
    }

    public SysAreaDTO getTree(){
        Object redisObj = redisService.get("sysAreaDTOJson");
        if(redisObj != null){
            String json = (String) redisObj;
            SysAreaDTO sysAreaDTO = new JsonMapper().fromJson(json, SysAreaDTO.class);
            return sysAreaDTO;
        }
        return refreshTreeRedis();
    }

    public List<SysAreaDTO> getListAll(){
        List<SysArea> sysAreaList = getService().findAll();
        List<SysAreaDTO> sysAreaDTOList = new ArrayList<>();
        for(SysArea sysArea : sysAreaList){
            SysAreaDTO sysAreaDTO = new SysAreaDTO();
            TransferUtil.transfer(sysAreaDTO, sysArea);
            sysAreaDTOList.add(sysAreaDTO);
        }
        return sysAreaDTOList;
    }

    public List<SysAreaDTO> getByParentId(List<SysAreaDTO> all, Long parentId){
        List<SysAreaDTO> children = new ArrayList<>();
        for(SysAreaDTO sysAreaDTO : all){
            if(sysAreaDTO.getParentId() == parentId){
                children.add(sysAreaDTO);
            }
        }
        return children;
    }

    public SysAreaDTO getById(List<SysAreaDTO> all, Long id){
        for(SysAreaDTO sysAreaDTO : all){
            if(sysAreaDTO.getId() == id){
                return sysAreaDTO;
            }
        }
        return null;
    }


    public void setChildren(List<SysAreaDTO> all, List<SysAreaDTO> children){
        if(!CollectionUtils.isEmpty(children)){
            for(SysAreaDTO sysAreaDTO : children){
                Long parentId = sysAreaDTO.getId();
                List<SysAreaDTO> children2 = getByParentId(all, parentId);
                sysAreaDTO.setChildren(children2);
                setChildren(all, children2);
            }
        }
    }

    private int update(SysArea sysArea){
        // 修改前
        SysArea before = findById(sysArea.getId());
        Long parentIdBefore = before.getParentId();
        String fullPathBefore = before.getFullPath()==null?"":before.getFullPath() + "/";
        String fullNameBefore = before.getFullName()==null?"":before.getFullName() + "/";
        int levelBefore = before.getLevel();
        // 修改
        SysArea parent = findById(sysArea.getParentId());
        String fullPath = parent.getFullPath()==null?"":parent.getFullPath() + "/" + sysArea.getId();
        String fullName = parent.getFullName()==null?"":parent.getFullName() + "/" + sysArea.getLabel();
        int level = parent.getLevel() + 1;
        sysArea.setFullPath(fullPath);
        sysArea.setFullName(fullName);
        sysArea.setLevel(level);
        int i = getService().updateByKey(sysArea);
        if(i != 1){
            throw new BadRequestException("修改失败");
        }
        // 修改后
        Long parentIdAfter = sysArea.getParentId();
        if(parentIdBefore == parentIdAfter){
            return i;
        }
        String fullPathAfter = fullPath + "/";
        String fullNameAfter = fullName + "/";
        int levelAfter = sysArea.getLevel();
        int levelDiff = levelAfter - levelBefore;
        // 修改所有子节点
        String sql = "update sys_area set full_path = replace(full_path,"+ fullPathBefore +","+fullPathAfter+"), full_name = replace(full_name,"+ fullNameBefore +","+fullNameAfter+"), level = (level + "+levelDiff+") where full_path like '%"+fullPathBefore+"%'";
        int j = getService().updateBySQL(sql);
        return j + i;
    }

    private int delete(Long id){
        SysArea sysArea = findById(id);
        if(sysArea == null){
            throw new BadRequestException("删除失败，原因：id不存在");
        }
        String fullPath = sysArea.getFullPath() + "/";
        int i = removeById(id);
        if(i != 1){
            throw new BadRequestException("删除失败");
        }
        String sql = "delete from sys_area where full_path like '%"+fullPath+"%'";
        int j = getService().deleteBySQL(sql);
        return i + j;
    }

    private SysAreaDTO refreshTreeRedis(){
        List<SysAreaDTO> all = getListAll();
        SysAreaDTO sysAreaDTO = getById(all, 0L);
        List<SysAreaDTO> children = getByParentId(all, 0L);
        sysAreaDTO.setChildren(children);
        setChildren(all, children);
        String sysAreaDTOJson = new JsonMapper().toJson(sysAreaDTO);
        redisService.set("sysAreaDTOJson", sysAreaDTOJson);
        return sysAreaDTO;
    }
}
