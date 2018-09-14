package com.jzfq.house.exception;

import org.springframework.http.HttpStatus;

/**
 * <B>文件名称：</B>BadRequestException<BR>
 * <B>文件描述：</B><BR>
 * <BR>
 * <B>版权声明：</B>(C)2016-2018<BR>
 * <B>公司部门：</B>东方银谷 研发二部 CBG<BR>
 * <B>创建时间：</B>2017/02/22<BR>
 *
 * @author 吕宏业  lvhongye@yingu.com
 * @version 1.0
 **/
public class BadRequestException extends BusinessException {

    public BadRequestException(String message) {
        super(HttpStatus.BAD_REQUEST.value(), message);
    }

}
