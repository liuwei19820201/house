package com.jzfq.house.mybatis.domain;

import lombok.Data;

import java.util.List;

@Data
public class SysAreaDTO {
    private Long id;
    private String label;
    private Long parentId;
    private String fullPath;
    private String fullName;
    private Integer level;
    private List<SysAreaDTO> children;
}