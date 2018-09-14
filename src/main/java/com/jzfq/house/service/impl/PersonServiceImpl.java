package com.jzfq.house.service.impl;

import com.jzfq.house.mybatis.domain.Person;
import com.jzfq.house.mybatis.domain.PersonQuery;
import com.jzfq.house.mybatis.mapper.PersonMapper;
import com.jzfq.house.mybatis.mapper.manual.PersonManualMapper;
import com.jzfq.house.service.PersonService;
import com.jzfq.house.util.MD5Util;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Map;

@Slf4j
@Service
public class PersonServiceImpl implements PersonService {

    @Autowired
    private PersonManualMapper personManualMapper;

    @Autowired
    private PersonMapper personMapper;

    /**
     * 根据分类查询对应的用户  classify：分类 1责任人，2参与人，3资源对接人
     *
     * @param person
     * @return
     */
    @Override
    public List<Map<String, Object>> findList(Person person) {
        return personManualMapper.findList(person);
    }

    @Override
    public List<Person> getByUsernameAndPassword(String username, String password) {
        PersonQuery PQ = new PersonQuery();
        PQ.createCriteria().andUsernameEqualTo(username).andPasswordEqualTo(MD5Util.getMD5String(password));
        return personMapper.selectByExample(PQ);
    }
}
