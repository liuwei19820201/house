package com.jzfq.house.swagger.model.amp;

import lombok.Data;

import java.util.Date;
import java.util.List;

/**
 * 环节入参
 *
 * @author Garen Gosling
 * @create 2018-04-21 14:11
 * @since v1.0
 */
@Data
public class ProjectLinkLeaderReq {
    private Integer projectLinkId; // 项目环节id
    private Integer leaderId;//负责人ID， 人员person表的ID
    private String leaderTel;
    private String updateUser;//修改人
}
