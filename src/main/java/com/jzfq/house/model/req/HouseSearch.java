package com.jzfq.house.model.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import javax.ws.rs.GET;

/**
 * @Title: HouseSearch
 * @Company: 北京桔子分期电子商务有限公司
 * @Author Li Zhe lizhe@juzifenqi.com
 * @Date 2018年09月06日 12:00
 * @Description:
 */
@Getter
@Setter
@ToString
public class HouseSearch {
    private String name; //房源名称

    private boolean scoreSort;//评分排序

    private boolean areaSort;//小区排序

}
