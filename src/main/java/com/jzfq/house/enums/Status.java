package com.jzfq.house.enums;

/**
 * 环节状态、项目状态
 *
 * @author liuwei
 */
public enum Status {
    S_1(1, "进行中"),
    S_2(2, "完成"),
    S_3(3, "终止"),
    S_4(4, "暂停"),
    S_5(5, "失败");

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回结果描述
     */
    private String message;

    Status(int code, String message) {
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
