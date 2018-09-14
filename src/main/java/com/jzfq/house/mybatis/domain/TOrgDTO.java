package com.jzfq.house.mybatis.domain;

import lombok.Data;

import java.util.Date;
import java.util.List;

@Data
public class TOrgDTO {
    private String id;
    private String label;
    private String parentId;
    private String fullName;
    private String fullPath;
    private Boolean available;
    private Integer level;
    private Date createTime;
    private Date updateTime;
    private List<TOrgDTO> children;
    private List<TPostDTO> postChildren;
    private List<THrDTO> hrChildren;
}