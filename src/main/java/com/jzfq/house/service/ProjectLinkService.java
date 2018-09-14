package com.jzfq.house.service;

import com.jzfq.house.model.res.ListResultRes;
import com.jzfq.house.mybatis.domain.ProjectLink;
import com.jzfq.house.swagger.model.amp.ProjectLinkLeaderReq;
import com.jzfq.house.swagger.model.amp.ProjectLinkReq;

import java.util.List;
import java.util.Map;

public interface ProjectLinkService {

    List<Map<String, Object>> findListAll(ProjectLinkReq req);

    ListResultRes<Map<String,Object>> getList(Integer page, Integer pageSize, ProjectLinkReq req);

    void save(ProjectLink projectLink);

    void delete(ProjectLinkReq req);

    void createProjectLink(ProjectLinkReq req);

    void updateProjectLinkStatus(ProjectLinkReq req);

    void updateProjectLinkDate(ProjectLinkReq req);

    void updateProjectLinkLeader(ProjectLinkReq req);

    void addeProjectLinkLeader(ProjectLinkLeaderReq req);
}
