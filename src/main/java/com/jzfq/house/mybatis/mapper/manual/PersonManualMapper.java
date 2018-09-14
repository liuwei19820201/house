package com.jzfq.house.mybatis.mapper.manual;

import com.github.pagehelper.Page;
import com.jzfq.house.mybatis.domain.Person;
import com.jzfq.house.swagger.model.amp.ProjectLinkReq;

import java.util.Map;

public interface PersonManualMapper {

    Page<Map<String, Object>> findList(Person person);

}