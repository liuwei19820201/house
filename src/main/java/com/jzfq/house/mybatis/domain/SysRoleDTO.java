package com.jzfq.house.mybatis.domain;

import lombok.Data;

@Data
public class SysRoleDTO{
    private Long id;
    private String code;
    private String name;
    private String resourceIds;
    private String resourceNames;
    private String project;
}