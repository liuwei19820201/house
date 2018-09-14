package com.jzfq.house.valid;

import com.jzfq.house.exception.BadRequestException;
import com.jzfq.house.mybatis.domain.SysPermission;
import com.jzfq.house.service.SysPermissionManage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SysPermissionValid {

    @Autowired
    SysPermissionManage sysPermissionManage;

    /**
     * 验证：新增接口
     * @param sysPermission
     */
    public void saveValid(SysPermission sysPermission){
        // 非空验证：参数对象
        if(sysPermission == null){
            throw new BadRequestException("参数对象不能为空");
        }
        // 非空验证：父节点
        if(sysPermission.getParentId() == null){
            throw new BadRequestException("父节点不能为空");
        }
        // 正确性校验: 父节点必需存在
        SysPermission byParentId = sysPermissionManage.findById(sysPermission.getParentId());
        if(byParentId == null){
            throw new BadRequestException("父节点不存在");
        }
        // 非空验证：节点名称
        if(StringUtils.isBlank(sysPermission.getLabel())){
            throw new BadRequestException("节点名称不能为空");
        }
        // 唯一性校验： 父节点下不能有同名子节点
        SysPermission byParentIdAndLabel = sysPermissionManage.getByParentIdAndLabel(sysPermission.getParentId(), sysPermission.getLabel());
        if(byParentIdAndLabel != null){
            throw new BadRequestException("相同父节点下不能有同名的子节点");
        }
    }

    /**
     * 验证：编辑接口
     * @param sysPermission
     */
    public void updateValid(SysPermission sysPermission){
        // 参数对象
        if(sysPermission == null){
            throw new BadRequestException("参数对象不能为空");
        }
        // 非空验证：ID不能为空
        if(sysPermission.getId() == null){
            throw new BadRequestException("ID不能为空");
        }
        // 非空验证：ID必需存在
        SysPermission byId = sysPermissionManage.findById(sysPermission.getId());
        if(byId == null){
            throw new BadRequestException("ID不存在");
        }
        // 唯一性校验: 父节点必需存在
        if(sysPermission.getParentId() != -1){
            SysPermission byParentId = sysPermissionManage.findById(sysPermission.getParentId());
            if(byParentId == null){
                throw new BadRequestException("父节点不存在");
            }
        }

        // 唯一性校验： 父节点下不能有同名子节点
        if(StringUtils.isNotBlank(sysPermission.getLabel()) && !sysPermission.getLabel().equals(byId.getLabel())){
            Long parentId = null;
            if(sysPermission.getParentId() != null){
                parentId = sysPermission.getParentId();
            }else{
                parentId = byId.getParentId();
            }
            SysPermission byParentIdAndLabel = sysPermissionManage.getByParentIdAndLabel(parentId, sysPermission.getLabel());
            if(byParentIdAndLabel != null){
                throw new BadRequestException("相同父节点下不能有同名的子节点");
            }
        }
    }

    /**
     * 验证：删除接口
     * @param id
     */
    public void deleteValid(Long id){
        if(id == null){
            throw new BadRequestException("ID不能为空");
        }
    }

    /**
     * 验证： 父ID查询接口
     * @param parentId
     */
    public void getByParentIdValid(Long parentId){
        if(parentId == null){
            throw new BadRequestException("父ID不能为空");
        }
    }
}
