package com.jzfq.house.mybatis.domain;

import lombok.Data;

import java.util.List;

@Data
public class SysPermissionDTO {
    private Long id;
    private Long parentId;
    private String label;
    private String type;
    private String url;
    private Boolean available;
    private String icon;
    private List<SysPermissionDTO> children;
}