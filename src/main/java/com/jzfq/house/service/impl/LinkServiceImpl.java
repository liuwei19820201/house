package com.jzfq.house.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzfq.house.enums.DelType;
import com.jzfq.house.model.res.ListResultRes;
import com.jzfq.house.mybatis.domain.Link;
import com.jzfq.house.mybatis.domain.LinkQuery;
import com.jzfq.house.mybatis.domain.ProjectLink;
import com.jzfq.house.mybatis.mapper.LinkMapper;
import com.jzfq.house.mybatis.mapper.ProjectLinkMapper;
import com.jzfq.house.mybatis.mapper.manual.ProjectLinkManualMapper;
import com.jzfq.house.service.LinkService;
import com.jzfq.house.service.ProjectLinkService;
import com.jzfq.house.swagger.model.amp.ProjectLinkReq;
import com.jzfq.house.util.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class LinkServiceImpl implements LinkService {

    @Autowired
    private LinkMapper linkMapper;

    @Override
    public Link findLinkByName(String projectLinkName) {
        LinkQuery linkQuery = new LinkQuery();
        linkQuery.createCriteria().andNameEqualTo(projectLinkName);
        List<Link> list = linkMapper.selectByExample(linkQuery);
        if(list != null && list.size() > 0) {
            return list.get(0);
        }
        return null;
    }

    @Override
    public Link saveLink(ProjectLinkReq req) {
        Link link = new Link();
        link.setName(req.getProjectLinkName());
        link.setSort(req.getSort());
        link.setTarget(req.getTarget());
        link.setDescription(req.getDescription());
        link.setDel(DelType.DEL_0.getCode());
        link.setCreateTime(DateUtil.getDate());
        link.setCreateUser(req.getCreateUser());
        linkMapper.insert(link);
        return link;
    }

}
