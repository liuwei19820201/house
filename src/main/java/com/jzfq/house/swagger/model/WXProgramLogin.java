package com.jzfq.house.swagger.model;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

/**
 * @Title: WXProgramLogin
 * @Company: 北京桔子分期电子商务有限公司
 * @Author Li Zhe lizhe@juzifenqi.com
 * @Date 2018年09月05日 18:13
 * @Description:
 */
@Getter
@Setter
@ToString
public class WXProgramLogin {

    private String username;

    private String password;

    private String phone;
}
