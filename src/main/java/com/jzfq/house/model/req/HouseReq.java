package com.jzfq.house.model.req;

import lombok.Getter;
import lombok.Setter;

import javax.validation.constraints.NotNull;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

/**
 * @Title: HouseReq
 * @Company: 北京桔子分期电子商务有限公司
 * @Author Li Zhe lizhe@juzifenqi.com
 * @Date 2018年09月05日 15:50
 * @Description:
 */
@Getter
@Setter
public class HouseReq {
    //编号
    @NotNull(groups = {UpdateValidation.class})
    private Integer id;
    //项目名称
    private String name;
    //房主姓名
    private String landlordName;
    //房主电话
    private String landlordTel;
    //房主身份证号码
    private String landlordIdcard;
    //小区ID
    private Integer areaId;
    //小区名称
    private String plotsName;
    //所在区域
    private String location;
    //房屋户型
    private String houseType;
    //户型结构
    private String houseStructure;
    //所在楼层
    private String floor;
    //建筑面积
    private String buildArea;
    //建筑年代
    private String buildAge;
    //套内面积
    private String innerArea;
    //建筑类型
    private String buildType;
    //房屋朝向
    private String houseDirection;
    //建筑结构
    private String buildStructure;
    //装修情况
    private String decorationSituation;
    //梯户比例
    private String elevatorRatio;
    //供暖方式
    private String heatingMode;
    //配备电梯
    private String haveElevator;
    //产权年限
    private String propertyRightYears;
    //挂牌时间
    private Date listingTime;
    //交易属性
    private String tradeAttr;
    //房屋用途
    private String houseUse;
    //房屋年限
    private String houseYears;
    //上次交易时间
    private Date lastTradeTime;
    //产权所属
    private String propertyRightAscription;
    //抵押信息
    private String mortgageInfo;
    //房本备件
    private String propertyCopy;
    //房源标签
    private String houseLabel;
    //小区介绍
    private String plotsIntroduce;
    //交通出行
    private String trafficTravel;
    //户型介绍
    private String houseTypeIntroduce;
    //核心卖点
    private String coreSellingPoint;
    //房主自荐
    private String landlordRecommend;
    //每平米单价
    private BigDecimal unitPrice;
    //房屋总价
    private BigDecimal housePrice;
    //登记时间
    private Date registerTime;
    //登记人
    private String registrant;
    //房源所在地经度
    private Double longitude;
    //房源所在地纬度
    private Double latitude;
    //联系人
    private String contacts;
    //联系人电话
    private String contactsTel;
    //地理位置
    private String address;
    //评分
    private String score;
    //门牌号
    private String doorNo;
    //备注
    private String remark;

    //================================
    //图片处理
    List<HouseImageReq> images;
    //================================

    //创建校验
    public interface CreateValidation {
    }

    //更新校验
    public interface UpdateValidation {
    }
}
