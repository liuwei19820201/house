package com.jzfq.house.swagger.model;

import lombok.Data;

@Data
public class TOrgVo {
    private String id;
    private String label;
    private String parentId;
    private String fullName;
    private String fullPath;
    private Boolean available;
    private Integer level;

}
