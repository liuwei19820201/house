package com.jzfq.house.swagger.model;

public class SysUserVo {
    private Long id;
    private String code;
    private String nickName;
    private String realName;
    private String password;
    private String phone;
    private String idNumber;
    private String province;
    private String city;
    private String wechat;
    private String qq;
    private String email;
    private String roles;

    public SysUserVo() {
    }

    public SysUserVo(Long id, String code, String nickName, String realName, String password, String phone, String idNumber, String province, String city, String wechat, String qq, String email, String roles) {
        this.id = id;
        this.code = code;
        this.nickName = nickName;
        this.realName = realName;
        this.password = password;
        this.phone = phone;
        this.idNumber = idNumber;
        this.province = province;
        this.city = city;
        this.wechat = wechat;
        this.qq = qq;
        this.email = email;
        this.roles = roles;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
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

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
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
