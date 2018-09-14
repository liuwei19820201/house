package com.jzfq.house.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzfq.house.enums.DelType;
import com.jzfq.house.enums.LinkPersonType;
import com.jzfq.house.enums.Status;
import com.jzfq.house.model.res.ListResultRes;
import com.jzfq.house.mybatis.domain.*;
import com.jzfq.house.mybatis.mapper.LinkPersonMapper;
import com.jzfq.house.mybatis.mapper.ProjectLinkMapper;
import com.jzfq.house.mybatis.mapper.manual.ProjectLinkManualMapper;
import com.jzfq.house.service.LinkService;
import com.jzfq.house.service.ProjectLinkService;
import com.jzfq.house.swagger.model.amp.ProjectLinkLeaderReq;
import com.jzfq.house.swagger.model.amp.ProjectLinkReq;
import com.jzfq.house.util.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ProjectLinkServiceImpl implements ProjectLinkService{

    @Autowired
    private ProjectLinkManualMapper projectLinkManualMapper;

    @Autowired
    private ProjectLinkMapper projectLinkMapper;

    @Autowired
    private LinkService linkService;

    @Autowired
    private LinkPersonMapper linkPersonMapper;

    /**
     * 查询项目环节列表
     * @param req
     * @return
     */
    @Override
    public List<Map<String, Object>> findListAll(ProjectLinkReq req) {
        List<Map<String, Object>> projectList = projectLinkManualMapper.findAll(req);
        return projectList;
    }

    /**
     * 分页查询项目环节列表
     * @param page
     * @param pageSize
     * @param req
     * @return
     */
    @Override
    public ListResultRes<Map<String, Object>> getList(Integer page, Integer pageSize, ProjectLinkReq req) {
        PageHelper.startPage(page, pageSize);
        Page<Map<String, Object>> listPage = projectLinkManualMapper.findAll(req);
        return ListResultRes.newListResult(listPage.getResult(), listPage.getTotal(), listPage.getPageNum(), listPage.getPageSize());
    }

    /**
     * 插人项目环节
     * @param projectLink
     */
    @Override
    public void save(ProjectLink projectLink) {
        projectLink.setCreateTime(DateUtil.getDate());
        projectLink.setDel(DelType.DEL_0.getCode());
        projectLinkMapper.insert(projectLink);
    }


    @Override
    public void delete(ProjectLinkReq req) {
        ProjectLink projectLink = new ProjectLink();
        projectLink.setId(req.getProjectLinkId());
        projectLink.setDel(DelType.DEL_1.getCode());
        projectLink.setUpdateUser(projectLink.getUpdateUser());
        projectLink.setUpdateTime(DateUtil.getDate());
        projectLinkMapper.updateByPrimaryKey(projectLink);
    }

    /**
     * 选中项目，添加环节
     * @param req
     */
    @Override
    public void createProjectLink(ProjectLinkReq req) {
        //1、添加环节  link 先用环节名称查是否已存在
        Link link = linkService.findLinkByName(req.getProjectLinkName());
        if(link == null){
            link = linkService.saveLink(req);
        }
        //2、添加项目环节  project_link
        ProjectLink projectLink = new ProjectLink();
        projectLink.setProjectId(req.getProjectId());
        projectLink.setProjectName(req.getProjectName());
        projectLink.setLinkId(link.getId());
        projectLink.setLeader(req.getLeaderId());
        projectLink.setLeaderTel(req.getLeaderTel());
        projectLink.setLinkName(req.getProjectLinkName());
        projectLink.setStatus(Status.S_1.getCode());
        projectLink.setTarget(req.getTarget());
        projectLink.setCreateTime(DateUtil.getDate());
        projectLink.setCreateUser(req.getCreateUser());
        projectLinkMapper.insert(projectLink);

        //3 添加参与人
        if(req.getParticipantsList() != null && req.getParticipantsList().size() > 0){
            for(ProjectLinkReq.Participants participants : req.getParticipantsList()){
                LinkPerson linkPerson = new LinkPerson();
                linkPerson.setProjectLinkId(projectLink.getId());
                linkPerson.setPersonId(participants.getPersonId());
                linkPerson.setLeader(participants.getLeader());
                linkPerson.setLeaderTel(participants.getLeaderTel());
                linkPerson.setType(LinkPersonType.LINK_PERSON_TYPE_2.getCode());
                linkPerson.setDel(DelType.DEL_0.getCode());
                linkPerson.setCreateTime(DateUtil.getDate());
                linkPerson.setCreateUser(req.getCreateUser());
                linkPersonMapper.insert(linkPerson);
            }
        }
        //4 添加资源人
        if(req.getResourceList() != null && req.getResourceList().size() > 0){
            for(ProjectLinkReq.Resource resource : req.getResourceList()){
                LinkPerson linkPerson = new LinkPerson();
                linkPerson.setProjectLinkId(projectLink.getId());
                linkPerson.setPersonId(resource.getPersonId());
                linkPerson.setLeader(resource.getLeader());
                linkPerson.setLeaderTel(resource.getLeaderTel());
                linkPerson.setType(LinkPersonType.LINK_PERSON_TYPE_3.getCode());
                linkPerson.setDel(DelType.DEL_0.getCode());
                linkPerson.setCreateTime(DateUtil.getDate());
                linkPerson.setCreateUser(req.getCreateUser());
                linkPersonMapper.insert(linkPerson);
            }
        }
    }

    /**
     * 更新项目环节状态
     * @param req
     */
    @Override
    public void updateProjectLinkStatus(ProjectLinkReq req) {
        projectLinkManualMapper.updateProjectLinkStatus(req);
    }

    /**
     * 更新项目起止时间
     * @param req
     */
    @Override
    public void updateProjectLinkDate(ProjectLinkReq req) {
        projectLinkManualMapper.updateProjectLinkDate(req);
    }

    /**
     * 更新环节负责人
     * @param req
     */
    @Override
    public void updateProjectLinkLeader(ProjectLinkReq req) {
        projectLinkManualMapper.updateProjectLinkLeader(req);
    }

    /**
     * 增加环节负责人
     * @param req
     */
    @Override
    public void addeProjectLinkLeader(ProjectLinkLeaderReq req) {
        ProjectLink projectLink = new ProjectLink();
        projectLink.setLeader(req.getLeaderId());
        projectLink.setLeaderTel(req.getLeaderTel());
        projectLink.setId(req.getProjectLinkId());
        projectLinkMapper.updateByPrimaryKey(projectLink);
    }
}
