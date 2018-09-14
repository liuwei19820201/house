package com.jzfq.house.service.impl;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.jzfq.house.enums.DelType;
import com.jzfq.house.jpa.repository.ProjectRepository;
import com.jzfq.house.model.res.ListResultRes;
import com.jzfq.house.mybatis.domain.Project;
import com.jzfq.house.mybatis.mapper.ProjectMapper;
import com.jzfq.house.mybatis.mapper.manual.ProjectManualMapper;
import com.jzfq.house.service.ProjectService;
import com.jzfq.house.swagger.model.amp.ProjectReq;
import com.jzfq.house.util.date.DateUtil;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class ProjectServiceImpl implements ProjectService{
    @Autowired
    ProjectRepository projectRepository;

    @Autowired
    private ProjectManualMapper projectManualMapper;

    @Autowired
    private ProjectMapper projectMapper;

    @Override
    public List<Map<String, Object>> findListAll(ProjectReq req) {
        List<Map<String, Object>> projectList = projectManualMapper.findAll(req);
        return projectList;
    }

    @Override
    public ListResultRes<Map<String, Object>> getList(Integer page, Integer pageSize, ProjectReq search) {
        PageHelper.startPage(page, pageSize);
        Page<Map<String, Object>> listPage = projectManualMapper.findAll(search);
        return ListResultRes.newListResult(listPage.getResult(), listPage.getTotal(), listPage.getPageNum(), listPage.getPageSize());
    }

    @Override
    public void save(Project project) {
        project.setCreateTime(DateUtil.getDate());
        project.setDel(DelType.DEL_0.getCode());
        projectMapper.insert(project);
    }


    @Override
    public void delete(Project project) {
        project.setDel(DelType.DEL_1.getCode());
        project.setUpdateTime(DateUtil.getDate());
        projectMapper.updateByPrimaryKey(project);
    }

}
