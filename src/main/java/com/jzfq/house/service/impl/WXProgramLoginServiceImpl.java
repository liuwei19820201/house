package com.jzfq.house.service.impl;

import com.jzfq.house.enums.TouchApiCode;
import com.jzfq.house.exception.TouchCodeException;
import com.jzfq.house.mybatis.domain.Person;
import com.jzfq.house.mybatis.domain.SysUser;
import com.jzfq.house.mybatis.domain.SysUserQuery;
import com.jzfq.house.mybatis.mapper.SysUserMapper;
import com.jzfq.house.mybatis.mapper.manual.SysUserManualMapper;
import com.jzfq.house.mybatis.service.SysUserService;
import com.jzfq.house.redis.RedisService;
import com.jzfq.house.service.PersonService;
import com.jzfq.house.service.WXProgramLoginService;
import com.jzfq.house.util.JwtHelper;
import com.jzfq.house.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;
import java.util.concurrent.TimeUnit;

/**
 * @Title: WXProgramLoginServiceImpl
 * @Company: 北京桔子分期电子商务有限公司
 * @Author Li Zhe lizhe@juzifenqi.com
 * @Date 2018年09月05日 17:04
 * @Description:
 */
@Slf4j
@Service
public class WXProgramLoginServiceImpl implements WXProgramLoginService {

    @Value("${wx.login.jwt.ttlMillis}")
    private int WX_LOGIN_JWT_TTLMILLIS;

    @Value("${wx.login.jwt.sec}")
    private String WX_LOGIN_JWT_SEC;

    @Value("${wx.login.timeout}")
    private Long WX_LOGIN_TIME_OUT;

    @Autowired
    private RedisService redisService;

    @Autowired
    private PersonService personService;

    @Override
    public String login(String username, String password) {
        List<Person> byUsernameAndPassword = personService.getByUsernameAndPassword(username, password);
        if (byUsernameAndPassword != null && byUsernameAndPassword.size() == 1) {
            Person person = byUsernameAndPassword.get(0);
            StringBuffer tokenStr = new StringBuffer("");
            tokenStr.append(person.getUsername()).append("@").append(person.getPassword()).append("@").append(person.getMobile1());
            String token = JwtHelper.createJWT(tokenStr.toString(), WX_LOGIN_JWT_TTLMILLIS, WX_LOGIN_JWT_SEC);
            redisService.incr(person.getUsername(), WX_LOGIN_TIME_OUT, TimeUnit.SECONDS);
            return token;
        }
        throw new TouchCodeException(TouchApiCode.TOUCH_API_CODE_0000);
    }

}
