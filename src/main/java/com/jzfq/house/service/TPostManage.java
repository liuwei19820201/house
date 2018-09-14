package com.jzfq.house.service;

import com.jzfq.house.exception.BadRequestException;
import com.jzfq.house.mybatis.domain.TPost;
import com.jzfq.house.mybatis.domain.TPostDTO;
import com.jzfq.house.mybatis.domain.TPostQuery;
import com.jzfq.house.mybatis.service.TPostService;
import com.jzfq.house.redis.RedisService;
import com.jzfq.house.swagger.model.TPostVo;
import com.jzfq.house.util.TransferUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.CollectionUtils;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

@Service
public class TPostManage extends BaseManage<String>{
    @Autowired
    TPostService<TPost, TPostQuery, String> service;
    @Autowired
    RedisService redisService;
    @Autowired
    TOrgManage tOrgManage;

    @Override
    public TPostService<TPost, TPostQuery, String> getService() {
        return service;
    }

    public boolean save(TPostVo TPostVo){
        TPost TPost = new TPost();
        TransferUtil.transfer(TPost, TPostVo);
        TPost.setCreateTime(new Date());
        int i = getService().save(TPost);
        if(i == 1){
            // 更新缓存
            tOrgManage.refreshTreeRedis(tOrgManage.getTreeByDB(tOrgManage.ROOT_NODE));
            return true;
        }else{
            return false;
        }
    }

    public boolean update(TPostVo TPostVo){
        TPost TPost = new TPost();
        TransferUtil.transfer(TPost, TPostVo);
        int i = getService().updateByKey(TPost);
        if(i == 1){
            // 更新缓存
            tOrgManage.refreshTreeRedis(tOrgManage.getTreeByDB(tOrgManage.ROOT_NODE));
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
        tOrgManage.refreshTreeRedis(tOrgManage.getTreeByDB(tOrgManage.ROOT_NODE));
        return count;
    }

    private int delete(String id){
        TPostQuery TPostQuery = new TPostQuery();
        com.jzfq.house.mybatis.domain.TPostQuery.Criteria criteria = TPostQuery.createCriteria();
        criteria.andIdEqualTo(id);
        int i = getService().delete(TPostQuery);
        if(i != 1){
            throw new BadRequestException("删除失败");
        }
        return i;
    }

    public List<TPostDTO> getListAll(){
        List<TPost> tPostList = getService().findAll();
        List<TPostDTO> tPostDTOList = new ArrayList<>();
        if(CollectionUtils.isEmpty(tPostDTOList)){
            return null;
        }
        for(TPost tPost : tPostList){
            TPostDTO tPostDTO = new TPostDTO();
            TransferUtil.transfer(tPostDTO, tPost);
            tPostDTOList.add(tPostDTO);
        }
        return tPostDTOList;
    }

    public List<TPostDTO> getByOrgId(List<TPostDTO> all, String orgId){
        if(CollectionUtils.isEmpty(all)){
            return new ArrayList<TPostDTO>();
        }
        List<TPostDTO> tPostDTOList = new ArrayList<>();
        for(TPostDTO tPostDTO : all){
            if(tPostDTO.getOrgId().equals(orgId)){
                tPostDTOList.add(tPostDTO);
            }
        }
        return tPostDTOList;
    }

    public TPost getById(String id){
        TPostQuery query = new TPostQuery();
        TPostQuery.Criteria criteria = query.createCriteria();
        criteria.andIdEqualTo(id);
        List<TPost> tPostList = getService().findBy(query);
        if(!CollectionUtils.isEmpty(tPostList)){
            return tPostList.get(0);
        }
        return null;
    }

    public TPost getByOrgIdAndLabel(String orgId, String label){
        TPostQuery query = new TPostQuery();
        TPostQuery.Criteria criteria = query.createCriteria();
        criteria.andOrgIdEqualTo(orgId);
        criteria.andLabelEqualTo(label);
        List<TPost> tPostList = getService().findBy(query);
        if(!CollectionUtils.isEmpty(tPostList)){
            return tPostList.get(0);
        }
        return null;
    }

}
