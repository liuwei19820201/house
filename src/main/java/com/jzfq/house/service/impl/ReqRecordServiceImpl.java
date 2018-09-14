package com.jzfq.house.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzfq.house.enums.DelType;
import com.jzfq.house.enums.ResourcesRecordType;
import com.jzfq.house.model.res.ListResultRes;
import com.jzfq.house.mybatis.domain.PayRecord;
import com.jzfq.house.mybatis.domain.ReqRecord;
import com.jzfq.house.mybatis.domain.ResourcesRecord;
import com.jzfq.house.mybatis.mapper.PayRecordMapper;
import com.jzfq.house.mybatis.mapper.ReqRecordMapper;
import com.jzfq.house.mybatis.mapper.ResourcesRecordMapper;
import com.jzfq.house.mybatis.mapper.manual.ResourceRecordManualMapper;
import com.jzfq.house.service.ReqRecordService;
import com.jzfq.house.service.ResourceRecordService;
import com.jzfq.house.swagger.model.amp.ReqRecordReq;
import com.jzfq.house.swagger.model.amp.ResourcesRecordReq;
import com.jzfq.house.util.TransferUtil;
import com.jzfq.house.util.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ReqRecordServiceImpl implements ReqRecordService {

    @Autowired
    private ReqRecordMapper reqRecordMapper;

    @Override
    public void delete(ReqRecordReq req) {
        ReqRecord reqRecord = new ReqRecord();
        reqRecord.setDel(DelType.DEL_1.getCode());
        reqRecord.setId(req.getReqId());
        reqRecord.setUpdateUser(req.getUpdateUser());
        reqRecord.setUpdateTime(DateUtil.getDate());
        reqRecordMapper.updateByPrimaryKey(reqRecord);
    }

    @Override
    public void save(ReqRecordReq req) {
        ReqRecord reqRecord = new ReqRecord();
        BeanUtils.copyProperties(req, reqRecord);
        reqRecord.setDel(DelType.DEL_0.getCode());
        reqRecord.setCreateTime(DateUtil.getDate());
        reqRecordMapper.insert(reqRecord);
    }

}
