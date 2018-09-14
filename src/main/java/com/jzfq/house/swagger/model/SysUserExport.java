package com.jzfq.house.swagger.model;

public class SysUserExport {
    private String nickName;
    private String realName;
    private String phone;
    private String idNumber;
    private String province;
    private String city;
    private String wechat;
    private String qq;
    private String email;
    private String roles;

    public SysUserExport() {
    }

    public SysUserExport(String nickName, String realName, String phone, String idNumber, String province, String city, String wechat, String qq, String email, String roles) {
        this.nickName = nickName;
        this.realName = realName;
        this.phone = phone;
        this.idNumber = idNumber;
        this.province = province;
        this.city = city;
        this.wechat = wechat;
        this.qq = qq;
        this.email = email;
        this.roles = roles;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    public String getRealName() {
        return realName;
    }

    public void setRealName(String realName) {
        this.realName = realName;
    }

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    public String getIdNumber() {
        return idNumber;
    }

    public void setIdNumber(String idNumber) {
        this.idNumber = idNumber;
    }

    public String getProvince() {
        return province;
    }

    public void setProvince(String province) {
        this.province = province;
    }

    public String getCity() {
        return city;
    }

    public void setCity(String city) {
        this.city = city;
    }

    public String getWechat() {
        return wechat;
    }

    public void setWechat(String wechat) {
        this.wechat = wechat;
    }

    public String getQq() {
        return qq;
    }

    public void setQq(String qq) {
        this.qq = qq;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getRoles() {
        return roles;
    }

    public void setRoles(String roles) {
        this.roles = roles;
    }
}
