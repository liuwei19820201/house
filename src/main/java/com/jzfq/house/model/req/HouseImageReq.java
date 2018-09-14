package com.jzfq.house.model.req;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Title: HouseImageReq
 * @Company: 北京桔子分期电子商务有限公司
 * @Author Li Zhe lizhe@juzifenqi.com
 * @Date 2018年09月06日 14:43
 * @Description:
 */
@Setter
@Getter
@ToString
public class HouseImageReq {

    private Integer id;

    private String imageName;

    private String imageUrl;

    private String type;
}
