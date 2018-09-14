package com.jzfq.house.service;

import com.jzfq.house.mybatis.domain.SysDictionary;
import com.jzfq.house.mybatis.domain.SysDictionaryDTO;
import com.jzfq.house.mybatis.domain.SysDictionaryQuery;
import com.jzfq.house.mybatis.service.SysDictionaryService;
import com.jzfq.house.redis.RedisService;
import com.jzfq.house.util.JsonMapper;
import com.jzfq.house.util.TransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.List;

@Service
public class SysDictionaryManage extends BaseManage<Long>{
    @Autowired
    SysDictionaryService<SysDictionary, SysDictionaryQuery, Long> service;
    @Autowired
    RedisService redisService;

    @Override
    public SysDictionaryService<SysDictionary, SysDictionaryQuery, Long> getService() {
        return service;
    }

    public boolean save(SysDictionary sysDictionary){
        int i = getService().save(sysDictionary);
        if(i == 1){
            refreshTreeRedis();
            return true;
        }
        return false;
    }

    public int updateMulti(List<SysDictionary> sysDictionaries){
        int count = 0;
        for(SysDictionary sysDictionary : sysDictionaries){
            count = count + getService().updateByKey(sysDictionary);
        }
        // 更新缓存
        refreshTreeRedis();
        return count;
    }

    public int deleteMulti(String ids){
        List<SysDictionaryDTO> listAll = getListAll();
        int count = 0;
        for(String idStr : ids.split(",")){
            count = count + delete(listAll, Long.parseLong(idStr));
        }
        // 更新缓存
        refreshTreeRedis();
        return count;
    }

    public SysDictionary getByParentIdAndLabel(Long parentId, String label){
        SysDictionaryQuery query = new SysDictionaryQuery();
        SysDictionaryQuery.Criteria criteria = query.createCriteria();
        criteria.andParentIdEqualTo(parentId);
        criteria.andLabelEqualTo(label);
        List<SysDictionary> sysDictionaryList = getService().findBy(query);
        if(sysDictionaryList == null || sysDictionaryList.size() == 0){
            return null;
        }
        return sysDictionaryList.get(0);
    }

    public SysDictionaryDTO getTree(){
        Object redisObj = redisService.get("sysDictionaryDTOJson");
        if(redisObj != null){
            String json = (String) redisObj;
            SysDictionaryDTO sysDictionaryDTO = new JsonMapper().fromJson(json, SysDictionaryDTO.class);
            return sysDictionaryDTO;
        }
        return refreshTreeRedis();
    }

    public List<SysDictionaryDTO> getListAll(){
        List<SysDictionary> sysDictionaryList = getService().findAll();
        List<SysDictionaryDTO> sysDictionaryDTOList = new ArrayList<>();
        for(SysDictionary sysDictionary : sysDictionaryList){
            SysDictionaryDTO sysDictionaryDTO = new SysDictionaryDTO();
            TransferUtil.transfer(sysDictionaryDTO, sysDictionary);
            sysDictionaryDTOList.add(sysDictionaryDTO);
        }
        return sysDictionaryDTOList;
    }

    public List<SysDictionaryDTO> getByParentId(List<SysDictionaryDTO> all, Long parentId){
        List<SysDictionaryDTO> children = new ArrayList<>();
        for(SysDictionaryDTO sysDictionaryDTO : all){
            if(sysDictionaryDTO.getParentId() == parentId){
                children.add(sysDictionaryDTO);
            }
        }
        return children;
    }

    public SysDictionaryDTO getById(List<SysDictionaryDTO> all, Long id){
        for(SysDictionaryDTO sysDictionaryDTO : all){
            if(sysDictionaryDTO.getId() == id){
                return sysDictionaryDTO;
            }
        }
        return null;
    }


    public void setChildren(List<SysDictionaryDTO> all, List<SysDictionaryDTO> children){
        if(!CollectionUtils.isEmpty(children)){
            for(SysDictionaryDTO sysDictionaryDTO : children){
                Long parentId = sysDictionaryDTO.getId();
                List<SysDictionaryDTO> children2 = getByParentId(all, parentId);
                sysDictionaryDTO.setChildren(children2);
                setChildren(all, children2);
            }
        }
    }

    private int delete(List<SysDictionaryDTO> all, Long id){
        SysDictionaryDTO sysDictionaryDTO = getById(all, id);
        List<Long> allChildrenIds = getAllChildrenIds(all, sysDictionaryDTO.getChildren());
        allChildrenIds.add(sysDictionaryDTO.getId());
        return deleteByIds(allChildrenIds);
    }

    private List<Long> getAllChildrenIds(List<SysDictionaryDTO> all, List<SysDictionaryDTO> children){
        List<Long> ids = new ArrayList<>();
        if(!CollectionUtils.isEmpty(children)){
            for(SysDictionaryDTO sysDictionaryDTO : children){
                ids.add(sysDictionaryDTO.getId());
                Long parentId = sysDictionaryDTO.getId();
                List<SysDictionaryDTO> children2 = getByParentId(all, parentId);
                getAllChildrenIds(all, children);
            }
        }
        return ids;
    }

    private int deleteByIds(List<Long> ids){
        SysDictionaryQuery query = new SysDictionaryQuery();
        SysDictionaryQuery.Criteria criteria = query.createCriteria();
        criteria.andIdIn(ids);
        return getService().delete(query);
    }


    private SysDictionaryDTO refreshTreeRedis(){
        List<SysDictionaryDTO> all = getListAll();
        SysDictionaryDTO sysDictionaryDTO = getById(all, 0L);
        List<SysDictionaryDTO> children = getByParentId(all, 0L);
        sysDictionaryDTO.setChildren(children);
        setChildren(all, children);
        String sysDictionaryDTOJson = new JsonMapper().toJson(sysDictionaryDTO);
        redisService.set("sysDictionaryDTOJson", sysDictionaryDTOJson);
        return sysDictionaryDTO;
    }

    public SysDictionary getByCode(String code){
        SysDictionaryQuery query = new SysDictionaryQuery();
        SysDictionaryQuery.Criteria criteria = query.createCriteria();
        criteria.andCodeEqualTo(code);
        List<SysDictionary> sysDictionarieList = getService().findBy(query);
        if(sysDictionarieList == null || sysDictionarieList.size() == 0){
            return null;
        }
        return sysDictionarieList.get(0);
    }
}
