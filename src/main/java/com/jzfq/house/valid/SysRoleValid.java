package com.jzfq.house.valid;

import com.jzfq.house.exception.BadRequestException;
import com.jzfq.house.mybatis.domain.SysRole;
import com.jzfq.house.service.SysRoleManage;
import com.jzfq.house.swagger.model.SysRoleVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SysRoleValid {

    @Autowired
    SysRoleManage sysRoleManage;

    /**
     * 验证：新增接口
     * @param sysRoleVo
     */
    public void saveValid(SysRoleVo sysRoleVo){
        // 参数对象
        if(sysRoleVo == null){
            throw new BadRequestException("参数对象不能为空");
        }
        // 非空验证：编码
        if(StringUtils.isBlank(sysRoleVo.getCode())){
            throw new BadRequestException("编码不能为空");
        }
        // 非空验证：名称
        if(StringUtils.isBlank(sysRoleVo.getName())){
            throw new BadRequestException("名称不能为空");
        }
        // 非空验证：项目名称
        if(StringUtils.isBlank(sysRoleVo.getProject())){
            throw new BadRequestException("项目名称不能为空");
        }
        // 唯一性验证：编码
        if(StringUtils.isNotBlank(sysRoleVo.getCode())){
            SysRole byCode = sysRoleManage.getByCode(sysRoleVo.getCode());
            if(byCode != null){
                throw new BadRequestException("编码已存在");
            }
        }
        // 唯一性校验：名称
        if(StringUtils.isNotBlank(sysRoleVo.getName())){
            SysRole byNameEqual = sysRoleManage.getByNameEqual(sysRoleVo.getName());
            if(byNameEqual != null){
                throw new BadRequestException("名称已存在");
            }
        }
    }

    /**
     * 验证：编辑接口
     * @param sysRoleVo
     */
    public void updateValid(SysRoleVo sysRoleVo){
        // 非空验证：参数对象
        if(sysRoleVo == null){
            throw new BadRequestException("参数对象不能为空");
        }
        // 非空验证：ID
        if(sysRoleVo.getId() == null){
            throw new BadRequestException("ID不能为空");
        }
        SysRole byID = sysRoleManage.getService().findByID(sysRoleVo.getId());
        // 唯一性验证：编码
        if(StringUtils.isNotBlank(sysRoleVo.getCode()) && !sysRoleVo.getCode().trim().equals(byID.getCode())){
            SysRole byCode = sysRoleManage.getByCode(sysRoleVo.getCode());
            if(byCode != null){
                throw new BadRequestException("编码已存在");
            }
        }
        // 唯一性验证：名称
        if(StringUtils.isNotBlank(sysRoleVo.getName()) && !sysRoleVo.getName().trim().equals(byID.getName())){
            SysRole byNameEqual = sysRoleManage.getByNameEqual(sysRoleVo.getName());
            if(byNameEqual != null){
                throw new BadRequestException("名称已存在");
            }
        }
    }

}
