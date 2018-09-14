package com.jzfq.house.enums;

/**
 * @Title: TouchApiCode
 * @Company: 北京桔子分期电子商务有限公司
 * @Author Li Zhe lizhe@juzifenqi.com
 * @Date 2018年07月20日 15:18
 * @Description: TODO(用一句话描述该文件做什么)
 */
public enum TouchApiCode {
    TOUCH_API_CODE_0000("0000", "账户未登录或登录TOKEN失效"),
    TOUCH_API_CODE_9999("9999", "调用失败");
    
    /**
     * 返回码
     */
    private String code;

    /**
     * 返回结果描述
     */
    private String msg;

    TouchApiCode(String code, String msg) {
        this.code = code;
        this.msg = msg;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
