package com.jzfq.house.mybatis.service;

import com.jzfq.house.mybatis.mapper.TOrgMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class TOrgService<T,Q,PK extends Serializable> extends CommonsService<T, Q, PK> {
    @Autowired
    TOrgMapper<T, Q, PK> tOrgMapper;
    @Override
    public TOrgMapper<T, Q, PK> getMapper() {
        return tOrgMapper;
    }
}
