package com.jzfq.house.service;

import com.jzfq.house.model.res.ListResultRes;
import com.jzfq.house.mybatis.domain.Link;
import com.jzfq.house.mybatis.domain.Project;
import com.jzfq.house.swagger.model.amp.ProjectLinkReq;
import com.jzfq.house.swagger.model.amp.ProjectReq;

import java.util.List;
import java.util.Map;

public interface LinkService {


    Link findLinkByName(String projectLinkName);

    Link saveLink(ProjectLinkReq req);
}
