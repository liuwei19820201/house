package com.jzfq.house.enums;

/**
 * person - Shield_State
 *
 * @author liuwei
 */
public enum ShieldState {
    SHIELD_0(0, "未屏蔽"),
    SHIELD_1(1, "已屏蔽");

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回结果描述
     */
    private String message;

    ShieldState(int code, String message) {
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
