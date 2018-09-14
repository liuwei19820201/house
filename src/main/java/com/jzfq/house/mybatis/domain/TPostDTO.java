package com.jzfq.house.mybatis.domain;

import lombok.Data;

import java.util.Date;

@Data
public class TPostDTO{
    private String id;
    private String label;
    private String orgId;
    private String fullName;
    private String fullPath;
    private Boolean available;
    private Integer level;
    private Date createTime;
    private Date updateTime;
}