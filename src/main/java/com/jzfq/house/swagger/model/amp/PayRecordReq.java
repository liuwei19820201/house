package com.jzfq.house.swagger.model.amp;

import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 项目入参
 *
 * @author Garen Gosling
 * @create 2018-04-21 14:11
 * @since v1.0
 */
@Data
public class PayRecordReq {
    private Integer payId;
    private Integer projectLinkId;
    private Integer resourcesRecordId;
    private Integer personId;
    private String personName;
    private BigDecimal payMoney;
    private Date payTime;
    private String payReason;
    private String bank;
    private String branch;
    private String account;
    private String payee;
    private List<ReqRecordInfo> reqRecordList;
    private String importantMatters;
    private String remark;
    private Integer del;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;

    @Data
    public static class ReqRecordInfo {
        private Integer reqId;//请款记录id
        private BigDecimal money;//针对此请款的付款金额
    }
}
