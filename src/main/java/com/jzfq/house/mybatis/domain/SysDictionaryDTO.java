package com.jzfq.house.mybatis.domain;

import lombok.Data;

import java.util.List;

@Data
public class SysDictionaryDTO {
    private Long id;
    private Long parentId;
    private String code;
    private String label;
    private String description;
    private String value;
    private String extend;
    private List<SysDictionaryDTO> children;
}