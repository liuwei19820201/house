package com.jzfq.house.exception;


import com.jzfq.house.mybatis.exception.DBException;
import com.jzfq.house.swagger.model.ErrorModel;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpServletResponse;


@ControllerAdvice
public class GlobalExceptionHandler {

    protected Logger LOGGER = LoggerFactory.getLogger(getClass());

    //TODO error log
    @ExceptionHandler(value = {Exception.class})
    @ResponseBody
    public ErrorModel exceptionHandler(Exception e, HttpServletResponse response) {
        LOGGER.error("Exception-{}", e.getMessage());
        e.printStackTrace();
        ErrorModel resp = new ErrorModel();
        resp.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        resp.setMessage("服务器异常，请联系管理员:" + e.getMessage());
        return resp;
    }

    @ExceptionHandler(value = {BusinessException.class})
    @ResponseBody //在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public ErrorModel exceptionHandler(BusinessException e, HttpServletResponse response) {
        LOGGER.error("BusinessException - {}", e.getMessage());
        ErrorModel resp = new ErrorModel();
        resp.setCode(       e.getCode());
        resp.setMessage(    e.getMessage());
        return resp;
    }

    @ExceptionHandler(value = {DBException.class})
    @ResponseBody //在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public ErrorModel exceptionHandler(DBException e, HttpServletResponse response) {
        LOGGER.error("DBException - {}", e.getMessage());
        ErrorModel resp = new ErrorModel();
        resp.setCode(       HttpStatus.INTERNAL_SERVER_ERROR.value());
        resp.setMessage(    e.getMessage());
        return resp;
    }

    @ExceptionHandler(value = {BadRequestException.class})
    @ResponseBody //在返回自定义相应类的情况下必须有，这是@ControllerAdvice注解的规定
    public ErrorModel exceptionHandler(BadRequestException e, HttpServletResponse response) {
        LOGGER.error("BadRequestException - {}", e.getMessage());
        ErrorModel resp = new ErrorModel();
        resp.setCode(       e.getCode());
        resp.setMessage(    e.getMessage());
        return resp;
    }

}
