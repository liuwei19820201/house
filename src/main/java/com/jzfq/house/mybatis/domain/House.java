package com.jzfq.house.mybatis.domain;

import lombok.Data;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;

@Data
@Entity
@Table(name = "house")
public class House implements Serializable {

    @Id
    @GeneratedValue(strategy=GenerationType.IDENTITY)
    @Column(length = 11)
    private Integer id;

    @Column(columnDefinition = "varchar(200) comment '项目名称'")
    private String name;

    @Column(columnDefinition = "varchar(200) comment '房主姓名'")
    private String landlordName;

    @Column(columnDefinition = "varchar(200) comment '房主电话'")
    private String landlordTel;

    @Column(columnDefinition = "varchar(200) comment '房主身份证号码'")
    private String landlordIdcard;

    @Column(columnDefinition = "int(11) comment '小区ID'")
    private Integer areaId;

    @Column(columnDefinition = "varchar(200) comment '小区名称'")
    private String plotsName;

    @Column(columnDefinition = "varchar(200) comment '所在区域'")
    private String location;

    @Column(columnDefinition = "varchar(200) comment '房屋户型'")
    private String houseType;

    @Column(columnDefinition = "varchar(200) comment '户型结构'")
    private String houseStructure;

    @Column(columnDefinition = "varchar(200) comment '所在楼层'")
    private String floor;

    @Column(columnDefinition = "varchar(200) comment '建筑面积'")
    private String buildArea;

    @Column(columnDefinition = "varchar(200) comment '建筑年代'")
    private String buildAge;

    @Column(columnDefinition = "varchar(200) comment '套内面积'")
    private String innerArea;

    @Column(columnDefinition = "varchar(200) comment '建筑类型'")
    private String buildType;

    @Column(columnDefinition = "varchar(200) comment '房屋朝向'")
    private String houseDirection;

    @Column(columnDefinition = "varchar(200) comment '建筑结构'")
    private String buildStructure;

    @Column(columnDefinition = "varchar(200) comment '装修情况'")
    private String decorationSituation;

    @Column(columnDefinition = "varchar(200) comment '梯户比例'")
    private String elevatorRatio;

    @Column(columnDefinition = "varchar(200) comment '供暖方式'")
    private String heatingMode;

    @Column(columnDefinition = "varchar(200) comment '配备电梯'")
    private String haveElevator;

    @Column(columnDefinition = "varchar(200) comment '产权年限'")
    private String propertyRightYears;

    @Column(columnDefinition = "datetime comment '挂牌时间'")
    private Date listingTime;

    @Column(columnDefinition = "varchar(200) comment '交易属性'")
    private String tradeAttr;

    @Column(columnDefinition = "varchar(200) comment '房屋用途'")
    private String houseUse;

    @Column(columnDefinition = "varchar(200) comment '房屋年限'")
    private String houseYears;

    @Column(columnDefinition = "datetime comment '上次交易时间'")
    private Date lastTradeTime;

    @Column(columnDefinition = "varchar(200) comment '产权所属'")
    private String propertyRightAscription;

    @Column(columnDefinition = "varchar(200) comment '抵押信息'")
    private String mortgageInfo;

    @Column(columnDefinition = "varchar(200) comment '房本备件'")
    private String propertyCopy;

    @Column(columnDefinition = "varchar(200) comment '房源标签'")
    private String houseLabel;

    @Column(columnDefinition = "varchar(200) comment '小区介绍'")
    private String plotsIntroduce;

    @Column(columnDefinition = "varchar(200) comment '交通出行'")
    private String trafficTravel;

    @Column(columnDefinition = "varchar(200) comment '户型介绍'")
    private String houseTypeIntroduce;

    @Column(columnDefinition = "varchar(200) comment '核心卖点'")
    private String coreSellingPoint;

    @Column(columnDefinition = "varchar(200) comment '房主自荐'")
    private String landlordRecommend;

    @Column(columnDefinition = "decimal(10,2) comment '每平米单价'")
    private BigDecimal unitPrice;

    @Column(columnDefinition = "decimal(10,2) comment '房屋总价'")
    private BigDecimal housePrice;

    @Column(columnDefinition = "datetime comment '登记时间'")
    private Date registerTime;

    @Column(columnDefinition = "varchar(200) comment '登记人'")
    private String registrant;

    @Column(columnDefinition = "double(10,6) comment '房源所在地经度'")
    private Double longitude;

    @Column(columnDefinition = "double(10,6) comment '房源所在地纬度'")
    private Double latitude;

    @Column(columnDefinition = "int(1) comment '当前状态 1未装修，2装修完成'")
    private Integer status;

    @Column(columnDefinition = "varchar(200) comment '联系人'")
    private String contacts;

    @Column(columnDefinition = "varchar(200) comment '联系人电话'")
    private String contactsTel;

    @Column(columnDefinition = "varchar(200) comment '地理位置'")
    private String address;

    @Column(columnDefinition = "varchar(200) comment '评分'")
    private String score;

    @Column(columnDefinition = "varchar(200) comment '门牌号'")
    private String doorNo;

    @Column(columnDefinition = "varchar(200) comment '备注'")
    private String remark;

    @Column(columnDefinition = "int(1) comment '删除标记 0未删除，1已删除'")
    private Integer del;

    @Column(columnDefinition = "datetime comment '创建时间'")
    private Date createTime;

    @Column(columnDefinition = "varchar(200) comment '创建人'")
    private String createUser;

    @Column(columnDefinition = "datetime comment '修改时间'")
    private Date updateTime;

    @Column(columnDefinition = "varchar(200) comment '修改人'")
    private String updateUser;
}