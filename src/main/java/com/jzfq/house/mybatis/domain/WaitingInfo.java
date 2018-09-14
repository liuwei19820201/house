package com.jzfq.house.mybatis.domain;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Author caishijian@juzifenqi.com
 * @Date 2018年06月26日 20:34
 * @Description: 待办项目环节
 */
@ToString
@Getter
@Setter
public class WaitingInfo {

    /**
     * 项目ID
     */
    private Integer projectId;

    /**
     * 项目名称
     */
    private String projectName;

    /**
     * 项目环节ID
     */
    private Integer projectLinkId;

    /**
     * 项目环节名称
     */
    private String linkName;

    /**
     * 项目环节顺序
     */
    private Integer linkSort;

    /**
     * 环节待办人
     */
    private String username;
}
