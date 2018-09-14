package com.jzfq.house.swagger.model;

/**
 * 查询参数对象
 *
 * @author Garen Gosling
 * @create 2018-04-21 14:11
 * @since v1.0
 */
public class SysUserSearch {
    private Integer start;
    private Integer length;
    private String code;
    private String nickName;
    private String realName;
    private String phone;

    public SysUserSearch() {
    }

    public SysUserSearch(Integer start, Integer length, String code, String nickName, String realName, String phone) {
        this.start = start;
        this.length = length;
        this.code = code;
        this.nickName = nickName;
        this.realName = realName;
        this.phone = phone;
    }

    public Integer getStart() {
        return start;
    }

    public void setStart(Integer start) {
        this.start = start;
    }

    public Integer getLength() {
        return length;
    }

    public void setLength(Integer length) {
        this.length = length;
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

    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Override
    public String toString() {
        return "SysUserSearch{" +
                "start=" + start +
                ", length=" + length +
                ", code='" + code + '\'' +
                ", nickName='" + nickName + '\'' +
                ", realName='" + realName + '\'' +
                ", phone='" + phone + '\'' +
                '}';
    }
}
