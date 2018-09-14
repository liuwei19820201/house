package com.jzfq.house.service.impl;

import com.jzfq.house.enums.DelType;
import com.jzfq.house.mybatis.domain.PayRecord;
import com.jzfq.house.mybatis.domain.PayReqRel;
import com.jzfq.house.mybatis.domain.ReqRecord;
import com.jzfq.house.mybatis.mapper.PayRecordMapper;
import com.jzfq.house.mybatis.mapper.PayReqRelMapper;
import com.jzfq.house.mybatis.mapper.ReqRecordMapper;
import com.jzfq.house.service.PayRecordService;
import com.jzfq.house.service.ReqRecordService;
import com.jzfq.house.swagger.model.amp.PayRecordReq;
import com.jzfq.house.swagger.model.amp.ReqRecordReq;
import com.jzfq.house.util.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Slf4j
@Service
public class PayRecordServiceImpl implements PayRecordService {

    @Autowired
    private PayRecordMapper payRecordMapper;

    @Autowired
    private PayReqRelMapper payReqRelMapper;

    @Override
    public void save(PayRecordReq req) {
        PayRecord payRecord = new PayRecord();
        BeanUtils.copyProperties(req, payRecord);
        payRecord.setDel(DelType.DEL_0.getCode());
        payRecord.setCreateTime(DateUtil.getDate());
        payRecordMapper.insert(payRecord);

        //添加付款记录对应的请款信息
        if(req.getReqRecordList() != null && req.getReqRecordList().size() > 0){
            for(PayRecordReq.ReqRecordInfo reqRecordInfo : req.getReqRecordList()){
                PayReqRel payReqRel = new PayReqRel();
                payReqRel.setPayId(payRecord.getId());
                payReqRel.setReqId(reqRecordInfo.getReqId());
                payReqRel.setPayMoney(reqRecordInfo.getMoney());
                payReqRel.setDel(DelType.DEL_0.getCode());
                payReqRel.setCreateTime(DateUtil.getDate());
                payReqRel.setCreateUser(req.getCreateUser());
                payReqRelMapper.insert(payReqRel);
            }
        }
    }

}
