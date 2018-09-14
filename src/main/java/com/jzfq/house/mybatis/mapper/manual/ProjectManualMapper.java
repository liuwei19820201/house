package com.jzfq.house.mybatis.mapper.manual;

import com.github.pagehelper.Page;
import com.jzfq.house.swagger.model.amp.ProjectReq;

import java.util.List;
import java.util.Map;

public interface ProjectManualMapper {

    Page<Map<String, Object>> findAll(ProjectReq req);

//    Page<Map<String,Object>> findList(ProjectReq search);
}