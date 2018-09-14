package com.jzfq.house.enums;

/**
 * LinkPerson 表 Type
 *
 * @author liuwei
 */
public enum LinkPersonType {
    LINK_PERSON_TYPE_2(2, "参与人"),
    LINK_PERSON_TYPE_3(3, "资源人");

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回结果描述
     */
    private String message;

    LinkPersonType(int code, String message) {
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
