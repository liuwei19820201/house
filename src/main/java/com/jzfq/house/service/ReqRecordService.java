package com.jzfq.house.service;

import com.jzfq.house.model.res.ListResultRes;
import com.jzfq.house.swagger.model.amp.ReqRecordReq;
import com.jzfq.house.swagger.model.amp.ResourcesRecordReq;

import java.util.List;
import java.util.Map;

public interface ReqRecordService {

    void delete(ReqRecordReq req);

    void save(ReqRecordReq req);
}
