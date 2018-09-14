package com.jzfq.house.service;

import com.jzfq.house.exception.BadRequestException;
import com.jzfq.house.mybatis.domain.*;
import com.jzfq.house.mybatis.service.TOrgService;
import com.jzfq.house.redis.RedisService;
import com.jzfq.house.swagger.model.TOrgVo;
import com.jzfq.house.util.JsonMapper;
import com.jzfq.house.util.TransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TOrgManage extends BaseManage<String>{
    @Autowired
    TOrgService<TOrg, TOrgQuery, String> service;
    @Autowired
    RedisService redisService;
    @Autowired
    TPostManage tPostManage;
    @Autowired
    THrManage tHrManage;

    @Override
    public TOrgService<TOrg, TOrgQuery, String> getService() {
        return service;
    }

    public final String ROOT_NODE = "0";

    public boolean save(TOrgVo tOrgVo){
        TOrg tOrg = new TOrg();
        TransferUtil.transfer(tOrg, tOrgVo);
        tOrg.setCreateTime(new Date());
        int i = getService().save(tOrg);
        if(i == 1){
            // 更新缓存
            refreshTreeRedis(getTreeByDB(ROOT_NODE));
            return true;
        }else{
            return false;
        }
    }

    public boolean update(TOrgVo tOrgVo){
        TOrgDTO before = getById(getListAll(), tOrgVo.getId());
        String fullPathBefore = before.getFullPath();
        String fullNameBefore = before.getFullName();
        TOrg tOrg = new TOrg();
        TransferUtil.transfer(tOrg, tOrgVo);
        int i = getService().updateByKey(tOrg);
        if(i == 1){
            // 修改所有子节点
            String sql = "update t_org set full_path = replace(full_path,'"+ fullPathBefore.trim() +"','"+tOrg.getFullPath().trim()+"'), full_name = replace(full_name,'"+ fullNameBefore.trim() +"','"+tOrg.getFullName().trim()+"') where full_path like '%"+fullPathBefore.trim()+"%'";
            getService().updateBySQL(sql);
            // 更新缓存
            refreshTreeRedis(getTreeByDB(ROOT_NODE));
            return true;
        }else{
            return false;
        }
    }

    public int deleteMulti(String ids){
        int count = 0;
        for(String id : ids.split(",")){
            count = count + delete(id);
        }
        // 更新缓存
        refreshTreeRedis(getTreeByDB(ROOT_NODE));
        return count;
    }

    private int delete(String id){
        TOrg byId = getById(id);
        if(byId == null){
            throw new BadRequestException("删除失败，原因：编码不存在");
        }
        String fullPath = byId.getFullPath() + "/";
        TOrgQuery tOrgQuery = new TOrgQuery();
        TOrgQuery.Criteria criteria = tOrgQuery.createCriteria();
        criteria.andIdEqualTo(id);
        int i = getService().delete(tOrgQuery);
        if(i != 1){
            throw new BadRequestException("删除失败");
        }
        String sql = "delete from t_org where full_path like '%"+fullPath+"%'";
        int j = getService().deleteBySQL(sql);
        return i + j;
    }

    public List<TOrgDTO> getListAll(){
        List<TOrg> tOrgList = getService().findAll();
        List<TOrgDTO> tOrgDTOList = new ArrayList<>();
        for(TOrg tOrg : tOrgList){
            TOrgDTO tOrgDTO = new TOrgDTO();
            TransferUtil.transfer(tOrgDTO, tOrg);
            tOrgDTOList.add(tOrgDTO);
        }
        return tOrgDTOList;
    }

    /**
     * 获取组织树，组织树包括：子组织、子岗位、子人员
     * @return
     */
    public TOrgDTO getTree(){
        Object redisObj = redisService.get("tOrgDTOJson");
        if(redisObj != null){
            String json = (String) redisObj;
            TOrgDTO tOrgDTO = new JsonMapper().fromJson(json, TOrgDTO.class);
            return tOrgDTO;
        }
        // 从数据库获取组织树
        TOrgDTO tOrgDTO = getTreeByDB("0");
        // 刷新缓存
        return refreshTreeRedis(tOrgDTO);
    }

    public List<TOrgDTO> getByParentId(List<TOrgDTO> all, String parentId){
        List<TOrgDTO> children = new ArrayList<>();
        for(TOrgDTO tOrgDTO : all){
            if(tOrgDTO.getParentId().equals(parentId)){
                children.add(tOrgDTO);
            }
        }
        return children;
    }

    public TOrgDTO getById(List<TOrgDTO> all, String id){
        if(CollectionUtils.isEmpty(all)){
            return null;
        }
        for(TOrgDTO tOrgDTO : all){
            if(tOrgDTO.getId().equals(id)){
                return tOrgDTO;
            }
        }
        return null;
    }

    public TOrg getById(String id){
        TOrgQuery query = new TOrgQuery();
        TOrgQuery.Criteria criteria = query.createCriteria();
        criteria.andIdEqualTo(id);
        List<TOrg> tOrgList = getService().findBy(query);
        if(!CollectionUtils.isEmpty(tOrgList)){
            return tOrgList.get(0);
        }
        return null;
    }

    /**
     * 数据库获取树
     * @param orgId
     * @return
     */
    public TOrgDTO getTreeByDB(String orgId){
        // org
        List<TOrgDTO> all = getListAll();
        TOrgDTO tOrgDTO = getById(all, orgId);
        if(tOrgDTO == null){
            return null;
        }
        List<TOrgDTO> children = getByParentId(all, orgId);
        tOrgDTO.setChildren(children);
        // post
        List<TPostDTO> postAll = tPostManage.getListAll();
        List<TPostDTO> postChildren = tPostManage.getByOrgId(postAll, orgId);
        tOrgDTO.setPostChildren(postChildren);
        // hr
        List<THrDTO> hrAll = tHrManage.getListAll();
        List<THrDTO> hrChildren = tHrManage.getByOrgId(hrAll, orgId);
        tOrgDTO.setHrChildren(hrChildren);
        // 递归设置子节点
        setChildren(children, all, postAll, hrAll);
        return tOrgDTO;
    }

    /**
     * 刷新redis
     * @param tOrgDTO
     */
    public TOrgDTO refreshTreeRedis(TOrgDTO tOrgDTO){
        String tOrgDTOJson = new JsonMapper().toJson(tOrgDTO);
        redisService.set("tOrgDTOJson", tOrgDTOJson);
        return tOrgDTO;
    }

    public void setChildren(List<TOrgDTO> children, List<TOrgDTO> all, List<TPostDTO> postAll, List<THrDTO> hrAll){
        if(!CollectionUtils.isEmpty(children)){
            for(TOrgDTO tOrgDTO : children){
                // org
                String parentId = tOrgDTO.getId();
                List<TOrgDTO> children2 = getByParentId(all, parentId);
                tOrgDTO.setChildren(children2);
                // post
                List<TPostDTO> postChildren = tPostManage.getByOrgId(postAll, parentId);
                tOrgDTO.setPostChildren(postChildren);
                // hr
                List<THrDTO> hrChildren = tHrManage.getByOrgId(hrAll, parentId);
                tOrgDTO.setHrChildren(hrChildren);
                // 递归设置子节点
                setChildren(children2, all, postAll, hrAll);
            }
        }
    }

    public TOrg getByParentIdAndLabel(String parentId, String label){
        TOrgQuery query = new TOrgQuery();
        TOrgQuery.Criteria criteria = query.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        criteria.andLabelEqualTo(label);
        List<TOrg> by = getService().findBy(query);
        if(!CollectionUtils.isEmpty(by)){
            return by.get(0);
        }
        return null;
    }
}
