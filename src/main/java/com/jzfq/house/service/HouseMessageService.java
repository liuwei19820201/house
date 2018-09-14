package com.jzfq.house.service;

import com.jzfq.house.model.req.HouseMessageReq;
import com.jzfq.house.model.req.HouseMessageSearch;
import com.jzfq.house.model.req.HouseReq;
import com.jzfq.house.model.req.HouseSearch;
import com.jzfq.house.model.res.HouseMessageRes;
import com.jzfq.house.model.res.HouseRes;
import com.jzfq.house.model.res.ListResultRes;
import com.jzfq.house.mybatis.domain.HouseMessage;

import java.util.List;

/**
 * @Title: HouseService
 * @Company: 北京桔子分期电子商务有限公司
 * @Author Li Zhe lizhe@juzifenqi.com
 * @Date 2018年09月06日 10:33
 * @Description:
 */
public interface HouseMessageService {


    /**
     * 獲取列表 -分页
     *
     * @param page
     * @param pageSize
     * @param search
     * @return
     */
    ListResultRes<HouseMessageRes> list(Integer page, Integer pageSize, HouseMessageSearch search);

    /**
     * 获得所有列表
     *
     * @param search
     * @return
     */
    List<HouseMessageRes> listAll(HouseMessageSearch search);

    /**
     * 通过id获取
     * @param id
     * @return
     */
    HouseMessageRes getById(Integer id);

    /**
     * 创建
     *
     * @param req
     */
    void create(HouseMessageReq req);

    /**
     * 修改
     *
     * @param req
     */
    void update(HouseMessageReq req);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Integer id);

    /**
     * 装修完成
     * @param id
     */
    void renovationComplete(Integer id);

}
