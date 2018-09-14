package com.jzfq.house.enums;

/**
 * @Title: HouseStatus
 * @Company: 北京桔子分期电子商务有限公司
 * @Author Li Zhe lizhe@juzifenqi.com
 * @Date 2018年09月06日 14:26
 * @Description: TODO(用一句话描述该文件做什么)
 */
public enum HouseStatus {
    _1(1, "未装修"),
    _2(2, "已装修");

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回结果描述
     */
    private String message;

    HouseStatus(int code, String message) {
        this.code = code;
        this.message = message;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
