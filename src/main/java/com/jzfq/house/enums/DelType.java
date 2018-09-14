package com.jzfq.house.enums;

/**
 * 对外接口日志描述信息   call_accounts_operation_log  call_assets_operation_log  call_risk_operation_log  service_type
 *
 * @author liuwei
 */
public enum DelType {
    DEL_0(0, "未删除"),
    DEL_1(1, "已删除");

    /**
     * 返回码
     */
    private int code;

    /**
     * 返回结果描述
     */
    private String message;

    DelType(int code, String message) {
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
