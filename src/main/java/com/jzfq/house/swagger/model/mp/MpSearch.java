package com.jzfq.house.swagger.model.mp;

import lombok.Data;

/**
 * 查询参数对象
 *
 * @author Garen Gosling
 * @create 2018-04-21 14:11
 * @since v1.0
 */
@Data
public class MpSearch {
    private Integer start;
    private Integer length;
    private String house_name;
    private String name;
    private String leader;
    private String leader_tel;
    private Integer status;


}
