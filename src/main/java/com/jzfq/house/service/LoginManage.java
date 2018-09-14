package com.jzfq.house.service;

import com.jzfq.house.mybatis.domain.SysPermissionDTO;
import com.jzfq.house.mybatis.domain.SysRole;
import com.jzfq.house.mybatis.domain.SysUser;
import com.jzfq.house.redis.RedisService;
import com.jzfq.house.swagger.model.LoginInfo;
import com.jzfq.house.util.JsonMapper;
import com.jzfq.house.valid.LoginValid;
import org.apache.commons.collections4.CollectionUtils;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class LoginManage {

    @Autowired
    LoginValid loginValid;
    @Autowired
    SysUserManage sysUserManage;
    @Autowired
    SysRoleManage sysRoleManage;
    @Autowired
    SysPermissionManage sysPermissionManage;
    @Autowired
    RedisService redisService;

    /**
     * 登录
     * @param loginName
     * @param password
     * @return
     */
    public LoginInfo login(String loginName, String password){
        // 非空验证
        loginValid.validNull(loginName, password);
        // 数据库查询
        SysUser byNickName = sysUserManage.getByNickName(loginName);
        // 正确性验证
        loginValid.validExist(byNickName, password);
        // 登录成功，返回登录信息对象
        return getLoginInfo(loginName, byNickName);
    }

    public boolean logout(String ticket){
        Long delH = redisService.delH(ticket, "loginInfo");
       if(delH == 1L){
           return true;
       }
       return false;
    }

    /**
     * 查询（构建）登录信息对象
     * @param loginName
     * @param byNickName
     * @return
     */
    public LoginInfo getLoginInfo(String loginName, SysUser byNickName){
        if(StringUtils.isBlank(loginName)){
            return null;
        }
        logout(loginName);
//        // 从redis中获取loginInfo
//        String loginInfoJson = redisService.getH(loginName, "loginInfo");
//        if(StringUtils.isNotBlank(loginInfoJson)){
//            return new JsonMapper().fromJson(loginInfoJson, LoginInfo.class);
//        }
        // 重新构建loginInfo
        LoginInfo loginInfo = new LoginInfo();
        // 用户信息
        if(byNickName == null){
            byNickName = sysUserManage.getByNickName(loginName);
            if(byNickName == null){
                return null;
            }
        }
        loginInfo.setUserInfo(byNickName);
        // 角色信息
        List<SysRole> roleList = getRoleList(byNickName.getRoles());
        loginInfo.setRoleList(roleList);
        // 权限树
        List<Long> permissionIds = getPermissionIds(roleList);
        SysPermissionDTO permissionTree = sysPermissionManage.getTree(permissionIds);
        loginInfo.setPermissionTree(permissionTree);
        // ticket
        loginInfo.setTicket(loginName);
        // 保存到redis中
        redisService.putH(loginName, "loginInfo", new JsonMapper().toJson(loginInfo));
        return loginInfo;
    }

    /**
     * 通过角色编码拼串获取角色集合
     * @param roles
     * @return
     */
    private List<SysRole> getRoleList(String roles){
        if(StringUtils.isBlank(roles)){
            return null;
        }
        String[] split = roles.split(",");
        List<SysRole> roleList = new ArrayList<>();
        for(String code : split){
            SysRole byCode = sysRoleManage.getByCode(code);
            if(byCode != null){
                roleList.add(byCode);
            }
        }
        return roleList;
    }

    /**
     * 通过用户角色拼串获取去重复的权限ID集合
     * @param roleList
     * @return
     */
    private List<Long> getPermissionIds(List<SysRole> roleList){
        if(CollectionUtils.isEmpty(roleList)){
            return null;
        }
        List<Long> permissionIds = new ArrayList<>();
        for(SysRole sysRole : roleList){
            String resourceIds = sysRole.getResourceIds();
            String[] split = resourceIds.split(",");
            for(String str : split){
                Long id = Long.parseLong(str);
                if(!permissionIds.contains(id)){
                    permissionIds.add(id);
                }
            }
        }
        return permissionIds;
    }





}
