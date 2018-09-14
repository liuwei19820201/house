package com.jzfq.house.service;

import com.jzfq.house.jpa.entity.House;
import com.jzfq.house.model.req.HouseReq;
import com.jzfq.house.model.req.HouseSearch;
import com.jzfq.house.model.res.HouseRes;
import com.jzfq.house.model.res.ListResultRes;

import java.util.List;

/**
 * @Title: HouseService
 * @Company: 北京桔子分期电子商务有限公司
 * @Author Li Zhe lizhe@juzifenqi.com
 * @Date 2018年09月06日 10:33
 * @Description:
 */
public interface HouseService {


    /**
     * 獲取列表 -分页
     *
     * @param page
     * @param pageSize
     * @param search
     * @return
     */
    ListResultRes<HouseRes> list(Integer page, Integer pageSize, HouseSearch search);

    /**
     * 获得所有列表
     *
     * @param search
     * @return
     */
    List<HouseRes> listAll(HouseSearch search);

    /**
     * 通过id获取
     * @param id
     * @return
     */
    HouseRes getById(Integer id);

    /**
     * 创建
     *
     * @param house
     */
    void create(HouseReq house);

    /**
     * 修改
     *
     * @param house
     */
    void update(HouseReq house);

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
