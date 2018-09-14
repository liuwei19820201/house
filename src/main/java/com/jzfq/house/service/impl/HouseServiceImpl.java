package com.jzfq.house.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzfq.house.enums.DelType;
import com.jzfq.house.enums.HouseStatus;
import com.jzfq.house.model.req.HouseImageReq;
import com.jzfq.house.model.req.HouseReq;
import com.jzfq.house.model.req.HouseSearch;
import com.jzfq.house.model.res.HouseRes;
import com.jzfq.house.model.res.ListResultRes;
import com.jzfq.house.mybatis.domain.House;
import com.jzfq.house.mybatis.domain.HouseImage;
import com.jzfq.house.mybatis.mapper.HouseMapper;
import com.jzfq.house.mybatis.mapper.manual.HouseManualMapper;
import com.jzfq.house.service.HouseImageService;
import com.jzfq.house.service.HouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * @Title: HouseServiceImpl
 * @Company: 北京桔子分期电子商务有限公司
 * @Author Li Zhe lizhe@juzifenqi.com
 * @Date 2018年09月06日 14:14
 * @Description:
 */
@Slf4j
@Service
public class HouseServiceImpl implements HouseService {

    @Autowired
    private HouseMapper houseMapper;

    @Autowired
    private HouseManualMapper houseManualMapper;

    @Autowired
    private HouseImageService houseImageService;

    @Override
    public ListResultRes<HouseRes> list(Integer page, Integer pageSize, HouseSearch search) {
        PageHelper.startPage(page, pageSize);
        Page<HouseRes> pageList = houseManualMapper.findList(search);
        return ListResultRes.newListResult(pageList.getResult(), pageList.getTotal(), pageList.getPageNum(), pageList.getPageSize());
    }

    @Override
    public List<HouseRes> listAll(HouseSearch search) {
        List<HouseRes> list = houseManualMapper.findList(search);
        return list;
    }

    @Override
    public HouseRes getById(Integer id) {
        House house = houseMapper.selectByPrimaryKey(id);
        if (house != null) {
            HouseRes res = new HouseRes();
            BeanUtils.copyProperties(house, res);
            //图片处理
            List<HouseImageReq> images = houseImageService.getListByProjectId(id).stream().map(x -> {
                HouseImageReq imageReq = new HouseImageReq();
                BeanUtils.copyProperties(x, imageReq);
                return imageReq;
            }).collect(Collectors.toList());
            //添加图片
            res.setImages(images);
            return res;
        }
        return null;
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(HouseReq house) {
        House createHouse = new House();
        BeanUtils.copyProperties(house, createHouse);
        createHouse.setStatus(HouseStatus._1.getCode());
        createHouse.setDel(DelType.DEL_0.getCode());
        createHouse.setCreateTime(new Date());
        createHouse.setUpdateTime(new Date());
        // TODO: 2018/9/6 缺少创建人
        houseMapper.insert(createHouse);
        //图片处理
        house.getImages().stream().forEach(x -> {
            houseImageService.create(createHouse.getId(), x);
        });
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(HouseReq house) {
        House updateHouse = houseMapper.selectByPrimaryKey(house.getId());
        if (updateHouse == null) {
            throw new RuntimeException("修改对象实例不存在");
        }
        BeanUtils.copyProperties(house, updateHouse);
        updateHouse.setUpdateTime(new Date());
        house.getImages().stream().forEach(x -> {
            if (x != null) {
                if (x.getId() != null) {
                    houseImageService.update(x);
                } else {
                    houseImageService.delete(x.getId());
                }
            }
        });
        // TODO: 2018/9/6 缺少修改人
        houseMapper.updateByPrimaryKey(updateHouse);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        House house = houseMapper.selectByPrimaryKey(id);
        if (house == null) {
            throw new RuntimeException("删除对象实例不存在");
        }
        if (house.getDel().equals(DelType.DEL_1.getCode())) {
            throw new RuntimeException("该对象已被删除");
        }
        house.setDel(DelType.DEL_1.getCode());
        house.setUpdateTime(new Date());
        // TODO: 2018/9/6 缺少删除人
        houseMapper.updateByPrimaryKey(house);
        //删除图片
        List<Integer> ids = houseImageService.getListByProjectId(id).stream().map(HouseImage::getId).collect(Collectors.toList());
        houseImageService.deleteBatch(ids);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void renovationComplete(Integer id) {
        House house = houseMapper.selectByPrimaryKey(id);
        if (house == null) {
            throw new RuntimeException("修改对象实例不存在");
        }
        if (house.getStatus().equals(HouseStatus._2.getCode())) {
            throw new RuntimeException("已经完成装修不需要点击提交");
        }
        house.setStatus(HouseStatus._2.getCode());
        house.setUpdateTime(new Date());
        // TODO: 2018/9/6 缺少修改人
        houseMapper.updateByPrimaryKey(house);
    }
}
