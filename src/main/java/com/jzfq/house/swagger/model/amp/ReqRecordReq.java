package com.jzfq.house.swagger.model.amp;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;

/**
 * 项目入参
 *
 * @author Garen Gosling
 * @create 2018-04-21 14:11
 * @since v1.0
 */
@Data
public class ReqRecordReq {
    private Integer reqId;
    private String updateUser;
    private Date updateDate;

    private Integer projectLinkId;
    private Integer resourcesRecordId;
    private Integer personId;
    private String personName;
    private String reqContent;
    private BigDecimal alreadyPay;
    private BigDecimal reqMoney;
    private Date reqTime;
    private String importantMatters;
    private String remark;
    private Integer del;
    private Date createTime;
    private String createUser;




}
