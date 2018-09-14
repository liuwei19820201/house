package com.jzfq.house.service;

import com.jzfq.house.mybatis.domain.SysDictionary;
import com.jzfq.house.redis.RedisService;
import com.jzfq.house.swagger.model.Option;
import org.apache.commons.collections4.CollectionUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OptionManage {

    @Autowired
    SysDictionaryManage sysDictionaryManage;
    @Autowired
    RedisService redisService;

    public List<Option> getIcons(){
        SysDictionary icon = sysDictionaryManage.getByCode("ICON");
        if(icon == null){
            return null;
        }
        String sql = "select code as value, label from sys_dictionary where parent_id = " + icon.getId();
        List<Map<String, Object>> bySQL = sysDictionaryManage.getService().findBySQL(sql);
        List<Option> optionList = new ArrayList<>();
        if(!CollectionUtils.isEmpty(bySQL)){
            for(Map<String, Object> map : bySQL){
                Option option = new Option();
                option.setValue((String) map.get("value"));
                option.setLabel((String) map.get("label"));
                optionList.add(option);
            }
        }
        return optionList;
    }


}
