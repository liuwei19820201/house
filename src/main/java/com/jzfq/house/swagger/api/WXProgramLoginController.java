package com.jzfq.house.swagger.api;

import com.jzfq.house.exception.TouchCodeException;
import com.jzfq.house.model.TouchResponseModel;
import com.jzfq.house.service.WXProgramLoginService;
import com.jzfq.house.swagger.model.TouchApiResponse;
import com.jzfq.house.swagger.model.WXProgramLogin;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;
import javax.ws.rs.core.MediaType;
import java.util.Map;

/**
 * @Title: WXProgramLoginController
 * @Company: 北京桔子分期电子商务有限公司
 * @Author Li Zhe lizhe@juzifenqi.com
 * @Date 2018年09月05日 18:08
 * @Description: 微信小程序登录
 */
@Slf4j
@RestController
@RequestMapping("/")
public class WXProgramLoginController {

    @Autowired
    private WXProgramLoginService wxProgramLoginService;

    @ApiOperation(value = "小程序商户端登录")
    @RequestMapping(value = "/wx/program/login", method = RequestMethod.POST)
    public ResponseEntity<TouchResponseModel> login(@RequestBody WXProgramLogin login) {
        try {
            String token = wxProgramLoginService.login(login.getUsername(), login.getPassword());
            return TouchApiResponse.success(token, "登录成功");
        } catch (TouchCodeException te) {
            log.error("小程序商户端登录:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getMessage());
        } catch (Exception e) {
            log.error("小程序商户端登录:{}", e.getMessage());
            return TouchApiResponse.failed(e.getMessage());
        }
    }
}
