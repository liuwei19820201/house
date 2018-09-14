package com.jzfq.house.swagger.model;

import lombok.Data;

/**
 * 查询参数对象
 *
 * @author Garen Gosling
 * @create 2018-04-21 14:11
 * @since v1.0
 */
@Data
public class SysRoleSearch {
    private Integer start;
    private Integer length;
    private String code;
    private String name;
    private String project;
}
