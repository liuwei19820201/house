package com.jzfq.house.swagger.model.amp;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

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
public class ProjectLinkReq {
    private Integer projectLinkId; // 项目环节id
    private String projectLinkName; //项目环节名称
    private String target; //环节目标
    private Integer sort;  //环节排序
    private String description; //环节描述
    private Integer del; //0 未删除 1 已删除
    private Integer projectStatus; //项目状态 1进行中、2完成、3终止、4暂停、5失败
    private Integer linkStatus; //环节状态 1进行中、2完成、3终止、4暂停、5失败
    private Integer projectId; //项目ID
    private String projectName; //项目名称
    private String leaderName;//负责人名称
    private Integer leaderId;//负责人ID， 人员person表的ID
    private String leaderTel;
    private Date startTime;
    private Date endTime;
    private String updateUser;//修改人
    private String createUser;//创建人
    private List<Participants> participantsList;//联系人 非必填
    private List<Resource> resourceList;//联系人 非必填

    //参与人
    @Data
    public static class Participants {
        private Integer personId;//id
        private String leader;//姓名
        private String leaderTel;//电话
    }
    //资源人
    @Data
    public static class Resource {
        private Integer personId;//id
        private String leader;//姓名
        private String leaderTel;//电话
    }
}
