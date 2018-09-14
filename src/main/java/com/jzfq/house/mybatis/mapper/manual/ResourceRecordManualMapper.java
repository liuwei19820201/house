package com.jzfq.house.mybatis.mapper.manual;

import com.github.pagehelper.Page;
import com.jzfq.house.swagger.model.amp.ResourcesRecordReq;

import java.util.Map;

public interface ResourceRecordManualMapper {

    Page<Map<String, Object>> findAll(ResourcesRecordReq req);

//    Page<Map<String,Object>> findList(ProjectReq search);
}