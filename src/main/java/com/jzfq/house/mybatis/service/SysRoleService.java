package com.jzfq.house.mybatis.service;

import com.jzfq.house.mybatis.mapper.SysRoleMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class SysRoleService<T,Q,PK extends Serializable> extends CommonsService<T, Q, PK> {
    @Autowired
    SysRoleMapper<T, Q, PK> sysRoleMapper;
    @Override
    public SysRoleMapper<T, Q, PK> getMapper() {
        return sysRoleMapper;
    }
}
