package com.jzfq.house.service.impl;

import com.jzfq.house.enums.DelType;
import com.jzfq.house.model.req.HouseImageReq;
import com.jzfq.house.mybatis.domain.HouseImage;
import com.jzfq.house.mybatis.domain.HouseImageQuery;
import com.jzfq.house.mybatis.mapper.HouseImageMapper;
import com.jzfq.house.service.HouseImageService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Title: HouseImageServiceImpl
 * @Company: 北京桔子分期电子商务有限公司
 * @Author Li Zhe lizhe@juzifenqi.com
 * @Date 2018年09月06日 15:23
 * @Description:
 */
@Slf4j
@Service
public class HouseImageServiceImpl implements HouseImageService {

    @Autowired
    private HouseImageMapper houseImageMapper;

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(Integer houseId, HouseImageReq houseImage) {
        HouseImage createHouseImage = new HouseImage();
        BeanUtils.copyProperties(houseImage, createHouseImage);
        createHouseImage.setCreateTime(new Date());
        // TODO: 2018/9/6 缺少创建人
        createHouseImage.setUpdateTime(new Date());
        createHouseImage.setDel(DelType.DEL_0.getCode());
        houseImageMapper.insert(createHouseImage);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(HouseImageReq houseImage) {
        HouseImage updateHouseImage = houseImageMapper.selectByPrimaryKey(houseImage.getId());
        if (updateHouseImage == null) {
            throw new RuntimeException("修改实例对象不存在");
        }
        BeanUtils.copyProperties(houseImage, updateHouseImage);
        updateHouseImage.setUpdateTime(new Date());
        // TODO: 2018/9/6 缺少修改人
        houseImageMapper.updateByPrimaryKey(updateHouseImage);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        HouseImage delHouseImage = houseImageMapper.selectByPrimaryKey(id);
        if (delHouseImage == null) {
            throw new RuntimeException("删除实例对象不存在");
        }
        delHouseImage.setDel(DelType.DEL_1.getCode());
        delHouseImage.setUpdateTime(new Date());
        // TODO: 2018/9/6 缺少删除人
        houseImageMapper.updateByPrimaryKey(delHouseImage);
    }

    @Override
    public void deleteBatch(List<Integer> ids) {
        HouseImageQuery HIQ = new HouseImageQuery();
        HIQ.createCriteria().andIdIn(ids);
        HouseImage houseImage = new HouseImage();
        houseImage.setDel(DelType.DEL_1.getCode());
        houseImageMapper.updateByExampleSelective(houseImage, HIQ);
    }

    @Override
    public List<HouseImage> getListByProjectId(Integer houseId) {
        HouseImageQuery HIQ = new HouseImageQuery();
        HIQ.createCriteria().andHouseIdEqualTo(houseId).andDelEqualTo(DelType.DEL_0.getCode());
        List<HouseImage> list = houseImageMapper.selectByExample(HIQ);
        return list;
    }
}
