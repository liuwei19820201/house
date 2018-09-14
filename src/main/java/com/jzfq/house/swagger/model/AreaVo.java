package com.jzfq.house.swagger.model;

import lombok.Data;

@Data
public class AreaVo {
    private Integer id;
    private String name;
    private String address;
    private Double longitude;
    private Double latitude;
    private String description;
    private Integer del;
}
