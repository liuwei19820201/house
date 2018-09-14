package com.jzfq.house.service;

import com.jzfq.house.mybatis.domain.WaitingProject;

import java.util.List;

public interface CommonBusinessService {

    List<WaitingProject> getMyWaitingTaskList(String username);
}
