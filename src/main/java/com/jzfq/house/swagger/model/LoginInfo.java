package com.jzfq.house.swagger.model;

import com.jzfq.house.mybatis.domain.SysPermissionDTO;
import com.jzfq.house.mybatis.domain.SysRole;
import com.jzfq.house.mybatis.domain.SysUser;
import lombok.Data;

import java.util.List;

@Data
public class LoginInfo {
    private SysUser userInfo;
    private List<SysRole> roleList;
    private SysPermissionDTO permissionTree;
    private String ticket;
}
