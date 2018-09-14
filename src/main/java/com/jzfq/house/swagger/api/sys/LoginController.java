package com.jzfq.house.swagger.api.sys;

import com.jzfq.house.service.LoginManage;
import com.jzfq.house.swagger.model.BaseModel;
import com.jzfq.house.swagger.model.LoginInfo;
import com.jzfq.house.swagger.model.ResponseModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import javax.validation.Valid;

@RestController
public class LoginController extends BaseModel {
    @Autowired
    LoginManage loginManage;

    @ApiOperation(value = "登录", notes = "登录")
    @RequestMapping(value = "/login", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> login(@ApiParam(value = "用户名") @Valid @RequestParam(value = "loginName", required = true) String loginName,
                                        @ApiParam(value = "密码") @Valid @RequestParam(value = "password", required = true) String password){
        LoginInfo loginInfo = loginManage.login(loginName, password);
        return new ResponseEntity<ResponseModel>(successModel("登录", loginInfo), HttpStatus.OK);
    }

    @ApiOperation(value = "退出", notes = "退出")
    @RequestMapping(value = "/api/logout", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> logout(HttpServletRequest request){
        String ticket = request.getHeader("ticket");
        boolean logout = loginManage.logout(ticket);
        if(logout){
            return new ResponseEntity<ResponseModel>(successModel("退出"), HttpStatus.OK);
        }else{
            return new ResponseEntity<ResponseModel>(badRequestModel("退出"), HttpStatus.OK);
        }
    }

}
