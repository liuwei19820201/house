package com.jzfq.house.model.res;

import lombok.Getter;
import lombok.Setter;

import java.math.BigDecimal;
import java.util.Date;

/**
 * @Title: HouseReq
 * @Company: 北京桔子分期电子商务有限公司
 * @Author Li Zhe lizhe@juzifenqi.com
 * @Date 2018年09月05日 15:50
 * @Description:
 */
@Getter
@Setter
public class HouseMessageRes {
    //编号
    private Integer id;
    //房源ID
    private Integer houseId;
    //房源名称
    private String houseName;
    //留言人ID
    private Integer fromPersonId;
    //留言人
    private String fromPersonName;
    //给谁留言ID
    private Integer toPersonId;
    //给谁留言
    private String toPersonName;
    //留言内容
    private String content;
    //留言时间
    private Date talkTime;
    //回复留言
    private String talkBack;
    //回复时间
    private Date backTime;
    //描述
    private String description;
}
