package com.jzfq.house.swagger.model;

import lombok.Data;

@Data
public class AreaSearch {
    private Integer start;
    private Integer length;
    private String name;
    private String address;
    private Integer del;
}
