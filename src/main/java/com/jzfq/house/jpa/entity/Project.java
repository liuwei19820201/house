package com.jzfq.house.jpa.entity;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Date;

@Entity
@Getter
@Setter
@Table(name = "project")
public class Project implements Serializable {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(length = 11, columnDefinition = "comment '主健'")
    private Integer id;

    @Column(columnDefinition = "int(11) comment '房源ID'")
    private Integer houseId;

    @Column(columnDefinition = "varchar(200) comment '房源名称'")
    private String houseName;

    @Column(columnDefinition = "varchar(200) comment '项目名称'")
    private String name;

    @Column(columnDefinition = "varchar(200) comment '项目负责人'")
    private String leader;

    @Column(columnDefinition = "varchar(200) comment '项目负责人电话'")
    private String leaderTel;

    @Column(columnDefinition = "int(1) comment '项目状态'")
    private Integer status;

    @Column(columnDefinition = "datetime comment '项目开始时间'")
    private Date projectStart;

    @Column(columnDefinition = "datetime comment '项目结束时间'")
    private Date projectEnd;

    @Column(columnDefinition = "varchar(200) comment '备注'")
    private String remark;

    @Column(columnDefinition = "int(1) comment '删除标识 0未删除，1已删除'")
    private Integer del;

    @Column(columnDefinition = "datetime comment '创建时间'")
    private Date createTime;

    @Column(columnDefinition = "varchar(30) comment '创建人'")
    private String createUser;

    @Column(columnDefinition = "datetime comment '修改时间'")
    private Date updateTime;

    @Column(columnDefinition = "varchar(30) comment '修改人'")
    private String updateUser;
}