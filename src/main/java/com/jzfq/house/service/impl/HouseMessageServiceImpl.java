package com.jzfq.house.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzfq.house.enums.DelType;
import com.jzfq.house.enums.HouseStatus;
import com.jzfq.house.model.req.HouseMessageReq;
import com.jzfq.house.model.req.HouseMessageSearch;
import com.jzfq.house.model.req.HouseReq;
import com.jzfq.house.model.req.HouseSearch;
import com.jzfq.house.model.res.HouseMessageRes;
import com.jzfq.house.model.res.HouseRes;
import com.jzfq.house.model.res.ListResultRes;
import com.jzfq.house.mybatis.domain.House;
import com.jzfq.house.mybatis.domain.HouseMessage;
import com.jzfq.house.mybatis.mapper.HouseMapper;
import com.jzfq.house.mybatis.mapper.HouseMessageMapper;
import com.jzfq.house.mybatis.mapper.manual.HouseManualMapper;
import com.jzfq.house.mybatis.mapper.manual.HouseMessageManualMapper;
import com.jzfq.house.service.HouseMessageService;
import com.jzfq.house.service.HouseService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.Date;
import java.util.List;

/**
 * @Title: HouseServiceImpl
 * @Company: 北京桔子分期电子商务有限公司
 * @Author Li Zhe lizhe@juzifenqi.com
 * @Date 2018年09月06日 14:14
 * @Description:
 */
@Slf4j
@Service
public class HouseMessageServiceImpl implements HouseMessageService {

    @Autowired
    private HouseMessageMapper houseMessageMapper;

    @Autowired
    private HouseMessageManualMapper houseMessageManualMapper;

    @Override
    public ListResultRes<HouseMessageRes> list(Integer page, Integer pageSize, HouseMessageSearch search) {
        PageHelper.startPage(page, pageSize);
        Page<HouseMessageRes> pageList = houseMessageManualMapper.findList(search);
        return ListResultRes.newListResult(pageList.getResult(), pageList.getTotal(), pageList.getPageNum(), pageList.getPageSize());
    }

    @Override
    public List<HouseMessageRes> listAll(HouseMessageSearch search) {
        List<HouseMessageRes> list = houseMessageManualMapper.findList(search);
        return list;
    }

    @Override
    public HouseMessageRes getById(Integer id) {
        HouseMessage house = houseMessageMapper.selectByPrimaryKey(id);
        if (house != null) {
            HouseMessageRes res = new HouseMessageRes();
            BeanUtils.copyProperties(house, res);
            return res;
        }
        return null;
    }

    /**
     * 给中介留言
     * @param req
     */
    @Override
    @Transactional(rollbackFor = Exception.class)
    public void create(HouseMessageReq req) {
        HouseMessage createHouseMessage = new HouseMessage();
        BeanUtils.copyProperties(req, createHouseMessage);
        createHouseMessage.setDel(DelType.DEL_0.getCode());
        createHouseMessage.setCreateTime(new Date());
        createHouseMessage.setUpdateTime(new Date());
        // TODO: 2018/9/6 缺少创建人
        houseMessageMapper.insert(createHouseMessage);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void update(HouseMessageReq house) {
        HouseMessage updateHouse = houseMessageMapper.selectByPrimaryKey(house.getId());
        if (updateHouse == null) {
            throw new RuntimeException("修改对象实例不存在");
        }
        BeanUtils.copyProperties(house, updateHouse);
        updateHouse.setUpdateTime(new Date());
        // TODO: 2018/9/6 缺少修改人
        houseMessageMapper.updateByPrimaryKey(updateHouse);
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void delete(Integer id) {
        if (houseMessageMapper.deleteByPrimaryKey(id) != 1) {
            throw new RuntimeException("删除对象实例不存在");
        }
    }

    @Override
    @Transactional(rollbackFor = Exception.class)
    public void renovationComplete(Integer id) {
        HouseMessage house = houseMessageMapper.selectByPrimaryKey(id);
        if (house == null) {
            throw new RuntimeException("修改对象实例不存在");
        }
        house.setUpdateTime(new Date());
        // TODO: 2018/9/6 缺少修改人
        houseMessageMapper.updateByPrimaryKey(house);
    }



}
