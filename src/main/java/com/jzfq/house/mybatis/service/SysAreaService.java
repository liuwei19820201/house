package com.jzfq.house.mybatis.service;

import com.jzfq.house.mybatis.mapper.SysAreaMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class SysAreaService<T,Q,PK extends Serializable> extends CommonsService<T, Q, PK> {
    @Autowired
    SysAreaMapper<T, Q, PK> sysAreaMapper;
    @Override
    public SysAreaMapper<T, Q, PK> getMapper() {
        return sysAreaMapper;
    }
}
