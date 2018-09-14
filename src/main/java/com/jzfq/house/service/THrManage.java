package com.jzfq.house.service;

import com.jzfq.house.mybatis.domain.THr;
import com.jzfq.house.mybatis.domain.THrDTO;
import com.jzfq.house.mybatis.domain.THrQuery;
import com.jzfq.house.mybatis.service.THrService;
import com.jzfq.house.redis.RedisService;
import com.jzfq.house.swagger.model.THrVo;
import com.jzfq.house.util.TransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class THrManage extends BaseManage<String>{
    @Autowired
    THrService<THr, THrQuery, String> service;
    @Autowired
    RedisService redisService;
    @Autowired
    TOrgManage tOrgManage;


    @Override
    public THrService<THr, THrQuery, String> getService() {
        return service;
    }

    public boolean save(THrVo tHrVo){
        THr tHr = new THr();
        TransferUtil.transfer(tHr, tHrVo);
        tHr.setCreateTime(new Date());
        int i = getService().save(tHr);
        if(i == 1){
            // 更新缓存
            tOrgManage.refreshTreeRedis(tOrgManage.getTreeByDB(tOrgManage.ROOT_NODE));
            return true;
        }else{
            return false;
        }
    }

    public boolean update(THrVo tHrVo){
        THr tHr = new THr();
        TransferUtil.transfer(tHr, tHrVo);
        int i = getService().updateByKey(tHr);
        if(i == 1){
            // 更新缓存
            tOrgManage.refreshTreeRedis(tOrgManage.getTreeByDB(tOrgManage.ROOT_NODE));
            return true;
        }else{
            return false;
        }
    }

    public int deleteMulti(String empNos){
        int count = 0;
        for(String empNo : empNos.split(",")){
            count = count + delete(empNo);
        }
        // 更新缓存
        tOrgManage.refreshTreeRedis(tOrgManage.getTreeByDB(tOrgManage.ROOT_NODE));
        return count;
    }

    private int delete(String id){
        THrQuery tHrQuery = new THrQuery();
        THrQuery.Criteria criteria = tHrQuery.createCriteria();
        criteria.andIdEqualTo(id);
        return getService().delete(tHrQuery);
    }

    public List<THrDTO> getListAll(){
        List<THr> tHrList = getService().findAll();
        if(CollectionUtils.isEmpty(tHrList)){
            return null;
        }
        List<THrDTO> tHrDTOList = new ArrayList<>();
        for(THr tHr : tHrList){
            THrDTO tHrDTO = new THrDTO();
            TransferUtil.transfer(tHrDTO, tHr);
            tHrDTOList.add(tHrDTO);
        }
        return tHrDTOList;
    }

    public List<THrDTO> getByOrgId(List<THrDTO> all, String orgId){
        if(CollectionUtils.isEmpty(all)){
            return new ArrayList<THrDTO>();
        }
        List<THrDTO> tHrDTOList = new ArrayList<>();
        for(THrDTO tHrDTO : all){
            if(tHrDTO.getOrgId().equals(orgId)){
                tHrDTOList.add(tHrDTO);
            }
        }
        return tHrDTOList;
    }

    public THr getById(String id){
        THrQuery query = new THrQuery();
        THrQuery.Criteria criteria = query.createCriteria();
        criteria.andIdEqualTo(id);
        List<THr> THrList = getService().findBy(query);
        if(!CollectionUtils.isEmpty(THrList)){
            return THrList.get(0);
        }
        return null;
    }
}
