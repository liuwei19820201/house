package com.jzfq.house.service.impl;

import com.jzfq.house.mybatis.domain.WaitingInfo;
import com.jzfq.house.mybatis.domain.WaitingLink;
import com.jzfq.house.mybatis.domain.WaitingProject;
import com.jzfq.house.mybatis.mapper.manual.ProjectLinkManualMapper;
import com.jzfq.house.service.CommonBusinessService;
import lombok.extern.slf4j.Slf4j;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class CommonBusinessServiceImpl implements CommonBusinessService {

    @Autowired
    private ProjectLinkManualMapper projectLinkManualMapper;

    /**
     * 根据登录用户名获取该用户对应的待办项目与待办环节
     * @param username
     * @return
     */
    @Override
    public List<WaitingProject> getMyWaitingTaskList(String username) {
        List<WaitingProject> waitingProjects = new ArrayList<>();
        List<WaitingInfo> waitingInfos = projectLinkManualMapper.selectWaitingInfos(username);
        if(CollectionUtils.isEmpty(waitingInfos)) {
            return waitingProjects;
        }
        // 构造待办项目及待办项目对应的项目环节
        Map<Integer,List<WaitingProject>> resultMap = new HashMap<>();
        for(WaitingInfo info : waitingInfos) {
            List<WaitingProject> tempWaitingProjects = resultMap.get(info.getProjectId());
            // 对象为空，新建对象
            if(CollectionUtils.isEmpty(tempWaitingProjects)) {
                tempWaitingProjects = new ArrayList<>();
                constructResultMap(resultMap, info, tempWaitingProjects);
            } else {
                constructResultMap(resultMap, info, tempWaitingProjects);
            }
        }
        // 合并为一个List
        List<WaitingProject> resultProject = new ArrayList<WaitingProject>();
        for(Integer key : resultMap.keySet()) {
            resultProject.addAll(resultMap.get(key));
        }
        return resultProject;
    }

    private void constructResultMap(Map<Integer, List<WaitingProject>> resultMap, WaitingInfo info, List<WaitingProject> tempWaitingProjects) {
        WaitingProject project = new WaitingProject();
        // 项目信息
        project.setProjectId(info.getProjectId());
        project.setProjectName(info.getProjectName());
        // 环节信息
        WaitingLink link = new WaitingLink();
        link.setProjectLinkId(info.getProjectLinkId());
        link.setLinkName(info.getLinkName());
        link.setLinkSort(info.getLinkSort());
        link.setUsername(info.getUsername());
        project.getWaitingLinks().add(link);
        tempWaitingProjects.add(project);
        resultMap.put(info.getProjectId(),tempWaitingProjects);
    }

}
