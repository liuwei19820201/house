package com.jzfq.house.mybatis.service;

import com.jzfq.house.mybatis.mapper.SysUserMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class SysUserService <T,Q,PK extends Serializable> extends CommonsService<T, Q, PK> {
    @Autowired
    SysUserMapper<T, Q, PK> sysUserMapper;
    @Override
    public SysUserMapper<T, Q, PK> getMapper() {
        return sysUserMapper;
    }
}
