package com.jzfq.house.swagger.model.amp;

import lombok.Data;

/**
 * 项目入参
 *
 * @author Garen Gosling
 * @create 2018-04-21 14:11
 * @since v1.0
 */
@Data
public class ProjectReq {
    private Integer projectId;
    private String houseName;
    private String name;
    private String leader;//person表username
    private Integer leaderId;//person表id
    private String leaderTel;
    private Integer status;
    private String projectStart;
    private String projectEnd;
}
