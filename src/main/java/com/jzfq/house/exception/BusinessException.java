package com.jzfq.house.exception;

import org.springframework.http.HttpStatus;

/**
 * <B>文件名称：</B><BR>
 * <B>文件描述：</B>业务异常<BR>
 * <BR>
 * <B>版权声明：</B>(C)2016-2018<BR>
 * <B>公司部门：</B>东方银谷 研发二部 CBG<BR>
 * <B>创建时间：</B>16/12/9<BR>
 *
 * @author 李云龙  liyunlong@yingu.com
 * @version 1.0
 **/


public class BusinessException extends RuntimeException{

    private int code = HttpStatus.INTERNAL_SERVER_ERROR.value();

    private String source;  // default UserManagement、crm

    public String getSource() {
        return source;
    }

    public void setSource(String source) {
        this.source = source;
    }

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public BusinessException(String message) {
        super(message);
    }

    public BusinessException(final int code, String message) {
        super(message);
        this.setCode(code);
    }
}
