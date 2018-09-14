package com.jzfq.house.mybatis.service;

import com.jzfq.house.mybatis.mapper.SysPermissionMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.io.Serializable;

@Service
public class SysPermissionService<T,Q,PK extends Serializable> extends CommonsService<T, Q, PK> {
    @Autowired
    SysPermissionMapper<T, Q, PK> sysPermissionMapper;
    @Override
    public SysPermissionMapper<T, Q, PK> getMapper() {
        return sysPermissionMapper;
    }
}
