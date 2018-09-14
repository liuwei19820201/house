package com.jzfq.house.service;

import com.jzfq.house.model.res.ListResultRes;
import com.jzfq.house.mybatis.domain.Project;
import com.jzfq.house.mybatis.domain.ResourcesRecord;
import com.jzfq.house.swagger.model.amp.ProjectReq;
import com.jzfq.house.swagger.model.amp.ResourcesRecordReq;

import java.util.List;
import java.util.Map;

public interface ResourceRecordService {

    List<Map<String, Object>> findListAll(ResourcesRecordReq req);

    ListResultRes<Map<String,Object>> getList(Integer page, Integer pageSize, ResourcesRecordReq req);

    void save(ResourcesRecordReq req);

    void delete(ResourcesRecordReq req);
}
