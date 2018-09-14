package com.jzfq.house.swagger.model.amp;

import com.jzfq.house.mybatis.domain.PayRecord;
import com.jzfq.house.mybatis.domain.ReqRecord;
import lombok.Data;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * 保存资源记录入参
 */
@Data
public class ResourcesRecordReq {
    private Integer id;
    private Integer projectLinkId;
    private String resName;
    private Integer personId;
    private String personName;
    private Long budget;
    private Long pay;
    private String importantMatters;
    private String content;
    private Integer type;
    private String commitPerson;
    private Date commitTime;
    private String remark;
    private Integer del;
    private Date createTime;
    private String createUser;
    private Date updateTime;
    private String updateUser;

    private List<ReqRecord_> reqRecordList;//请款记录
    private List<PayRecord_> payRecordList;//付款记录

    //请款记录
    @Data
    public static class ReqRecord_ {
        private Integer personId;//资源人ID
        private String personName;//资源人姓名
        private String reqContent;//请款内容
        private BigDecimal alreadyPay;//已支付金额
        private BigDecimal reqMoney;//请款金额
        private Date reqTime;//请款时间
        private String importantMatters;//重要事项
    }
    //付款记录
    @Data
    public static class PayRecord_ {
        private Integer personId;//资源人ID
        private String personName;//资源人姓名
        private BigDecimal payMoney;//付款金额
        private Date payTime;//付款时间
        private String reqRecordIds;//关联请款流水账ID，逗号分隔
        private String importantMatters;//重要事项
    }

}
