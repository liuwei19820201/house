package com.jzfq.house.service;

import com.jzfq.house.mybatis.domain.Person;

import java.util.List;
import java.util.Map;

public interface PersonService {


    List<Map<String, Object>> findList(Person person);

    /**
     * 登录查询用户
     *
     * @param username 用户名
     * @param password 密码
     * @return
     */
    List<Person> getByUsernameAndPassword(String username, String password);
}
