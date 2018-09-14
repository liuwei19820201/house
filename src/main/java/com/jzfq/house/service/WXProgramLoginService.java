package com.jzfq.house.service;

/**
 * @Title: WXProgramLoginService
 * @Company: 北京桔子分期电子商务有限公司
 * @Author Li Zhe lizhe@juzifenqi.com
 * @Date 2018年09月05日 16:50
 * @Description: 小程序登录
 */
public interface WXProgramLoginService {
    /**
     * 用户登录  code+password || phone+password
     *
     * @param username 用户名称
     * @param password 用户密码
     * @return
     */
    String login(String username, String password);
}
