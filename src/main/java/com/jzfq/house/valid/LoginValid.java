package com.jzfq.house.valid;


import com.jzfq.house.exception.BadRequestException;
import com.jzfq.house.mybatis.domain.SysUser;
import com.jzfq.house.util.MD5Util;
import org.apache.commons.lang3.StringUtils;
import org.springframework.stereotype.Component;

@Component
public class LoginValid {

    /**
     * 非空验证
     * @param loginName
     * @param password
     */
    public void validNull(String loginName, String password){
        // 非空验证：登录名
        if(StringUtils.isBlank(loginName)){
            throw new BadRequestException("用户名不能为空");
        }
        // 非空验证：密码
        if(StringUtils.isBlank(password)){
            throw new BadRequestException("密码不能为空");
        }
    }

    /**
     * 正确性验证
     * @param byNickName
     * @param password
     */
    public void validExist(SysUser byNickName, String password){
        if(byNickName == null){
            throw new BadRequestException("用户名不存在");
        }
        if(!byNickName.getPassword().equals(MD5Util.getMD5String(password))){
            throw new BadRequestException("密码不正确");
        }
    }



}
