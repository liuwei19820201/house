package com.jzfq.house.mybatis.mapper.manual;

import com.github.pagehelper.Page;
import com.jzfq.house.mybatis.domain.WaitingInfo;
import com.jzfq.house.swagger.model.amp.ProjectLinkReq;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

public interface ProjectLinkManualMapper {

    Page<Map<String, Object>> findAll(ProjectLinkReq req);

    void updateProjectLinkStatus(ProjectLinkReq req);

    void updateProjectLinkDate(ProjectLinkReq req);

    List<WaitingInfo> selectWaitingInfos(@Param("username") String username);

    void updateProjectLinkLeader(ProjectLinkReq req);
}