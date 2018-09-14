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
import com.jzfq.house.service.ResourceRecordService;
import com.jzfq.house.swagger.model.amp.ResourcesRecordReq;
import com.jzfq.house.util.TransferUtil;
import com.jzfq.house.util.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ResourceRecordServiceImpl implements ResourceRecordService {

    @Autowired
    private ResourceRecordManualMapper resourceRecordManualMapper;

    @Autowired
    private ResourcesRecordMapper resourcesRecordMapper;

    @Autowired
    private ReqRecordMapper reqRecordMapper;

    @Autowired
    private PayRecordMapper payRecordMapper;

    @Override
    public List<Map<String, Object>> findListAll(ResourcesRecordReq req) {
        List<Map<String, Object>> projectList = resourceRecordManualMapper.findAll(req);
        return projectList;
    }

    @Override
    public ListResultRes<Map<String, Object>> getList(Integer page, Integer pageSize, ResourcesRecordReq search) {
        PageHelper.startPage(page, pageSize);
        Page<Map<String, Object>> listPage = resourceRecordManualMapper.findAll(search);
        return ListResultRes.newListResult(listPage.getResult(), listPage.getTotal(), listPage.getPageNum(), listPage.getPageSize());
    }

    @Override
    public void save(ResourcesRecordReq req) {
        ResourcesRecord resourcesRecord = new ResourcesRecord();
        TransferUtil.transfer(resourcesRecord, req);
        resourcesRecord.setCreateTime(DateUtil.getDate());
        resourcesRecord.setDel(DelType.DEL_0.getCode());
        resourcesRecordMapper.insert(resourcesRecord);
        //保存请款记录
        if(ResourcesRecordType.TYPE_2.getCode() == resourcesRecord.getType()){
            if(req.getReqRecordList() != null && req.getReqRecordList().size() > 0){
                for(ResourcesRecordReq.ReqRecord_ reqRecord : req.getReqRecordList()){
                    ReqRecord record = new ReqRecord();
                    record.setProjectLinkId(req.getProjectLinkId());
                    record.setResourcesRecordId(resourcesRecord.getId());
                    record.setPersonId(reqRecord.getPersonId());
                    record.setPersonName(reqRecord.getPersonName());
                    record.setReqContent(reqRecord.getReqContent());
                    record.setAlreadyPay(reqRecord.getAlreadyPay());
                    record.setReqMoney(reqRecord.getReqMoney());
                    record.setReqTime(reqRecord.getReqTime());
                    record.setImportantMatters(reqRecord.getImportantMatters());
                    reqRecordMapper.insert(record);
                }
            }
        }
        //保存付款记录
        if(ResourcesRecordType.TYPE_3.getCode() == resourcesRecord.getType()){
            if(req.getPayRecordList() != null && req.getPayRecordList().size() > 0){
                for(ResourcesRecordReq.PayRecord_ payRecord : req.getPayRecordList()){
                    PayRecord record = new PayRecord();
                    record.setProjectLinkId(req.getProjectLinkId());
                    record.setResourcesRecordId(resourcesRecord.getId());
                    record.setPersonId(payRecord.getPersonId());
                    record.setPersonName(payRecord.getPersonName());
                    record.setPayMoney(payRecord.getPayMoney());
                    record.setPayTime(payRecord.getPayTime());
                    payRecordMapper.insert(record);
                }
            }
        }
    }

    @Override
    public void delete(ResourcesRecordReq req) {
        ResourcesRecord resourcesRecord = new ResourcesRecord();
        resourcesRecord.setDel(DelType.DEL_1.getCode());
        resourcesRecord.setId(req.getId());
        resourcesRecord.setUpdateUser(req.getUpdateUser());
        resourcesRecord.setUpdateTime(DateUtil.getDate());
        resourcesRecordMapper.updateByPrimaryKey(resourcesRecord);
    }

}
