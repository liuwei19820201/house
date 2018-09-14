package com.jzfq.house.mybatis.domain;


import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.util.ArrayList;
import java.util.List;

/**
 * @Author caishijian@juzifenqi.com
 * @Date 2018年06月26日 20:34
 * @Description: 待办项目
 */
@ToString
@Getter
@Setter
public class WaitingProject {

    /**
     * 项目ID
     */
    private Integer projectId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 环节
     */
    private List<WaitingLink> waitingLinks = new ArrayList<>();
}
