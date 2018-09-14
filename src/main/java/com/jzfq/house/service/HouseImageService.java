package com.jzfq.house.service;

import com.jzfq.house.model.req.HouseImageReq;
import com.jzfq.house.mybatis.domain.HouseImage;

import java.util.List;

/**
 * @Title: HouseImageService
 * @Company: 北京桔子分期电子商务有限公司
 * @Author Li Zhe lizhe@juzifenqi.com
 * @Date 2018年09月06日 15:08
 * @Description:
 */
public interface HouseImageService {

    /**
     * 添加
     *
     * @param houseImage
     */
    void create(Integer houseId, HouseImageReq houseImage);

    /**
     * 修改
     *
     * @param houseImage
     */
    void update(HouseImageReq houseImage);

    /**
     * 删除
     *
     * @param id
     */
    void delete(Integer id);

    /**
     * 批量删除
     *
     * @param ids
     */
    void deleteBatch(List<Integer> ids);

    /**
     * 通过houseId获取图片
     * *
     *
     * @param houseId
     * @return
     */
    List<HouseImage> getListByProjectId(Integer houseId);
}
