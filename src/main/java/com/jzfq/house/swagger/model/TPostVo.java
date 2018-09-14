package com.jzfq.house.swagger.model;

import lombok.Data;

@Data
public class TPostVo {
    private String id;
    private String label;
    private String orgId;
    private String fullName;
    private String fullPath;
    private Boolean available;
    private Integer level;
}
