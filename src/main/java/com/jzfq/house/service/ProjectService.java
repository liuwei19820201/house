package com.jzfq.house.service;

import com.jzfq.house.model.res.ListResultRes;
import com.jzfq.house.mybatis.domain.Project;
import com.jzfq.house.swagger.model.amp.ProjectReq;

import java.util.List;
import java.util.Map;

public interface ProjectService {

    List<Map<String, Object>> findListAll(ProjectReq req);

    ListResultRes<Map<String,Object>> getList(Integer page, Integer pageSize, ProjectReq req);

    void save(Project project);

    void delete(Project project);

}
