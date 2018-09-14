package com.jzfq.house.mybatis.mapper.manual;

import com.jzfq.house.mybatis.domain.SysUser;
import org.apache.ibatis.annotations.Param;

import java.util.List;
import java.util.Map;

/**
 * @Title: SysUserManualMapper
 * @Company: 北京桔子分期电子商务有限公司
 * @Author Li Zhe lizhe@juzifenqi.com
 * @Date 2018年09月05日 17:55
 * @Description:
 */
public interface SysUserManualMapper {
    /**
     * 通过 用户code 或者phone 加 password
     *
     * @param code
     * @param phone
     * @param password
     * @return
     */
    List<Map<String,String>> findByCodeOrPhoneOfPassword(@Param("code") String code, @Param("phone") String phone, @Param("password") String password);

}
