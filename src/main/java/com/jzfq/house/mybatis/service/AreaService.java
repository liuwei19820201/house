package com.jzfq.house.mybatis.service;

import com.jzfq.house.mybatis.mapper.AreaMapper;
import com.jzfq.house.mybatis.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class AreaService<T,Q,PK extends Serializable> extends CommonsService<T, Q, PK> {
    @Autowired
    AreaMapper<T, Q, PK> areaMapper;
    @Override
    public AreaMapper<T, Q, PK> getMapper() {
        return areaMapper;
    }
}
