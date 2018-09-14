package com.jzfq.house.valid;

import com.jzfq.house.exception.BadRequestException;
import com.jzfq.house.mybatis.domain.TOrg;
import com.jzfq.house.service.TOrgManage;
import com.jzfq.house.swagger.model.TOrgVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TOrgValid {

    @Autowired
    TOrgManage tOrgManage;

    /**
     * 验证：新增接口
     * @param tOrgVo
     */
    public void saveValid(TOrgVo tOrgVo){
        // 非空验证：参数对象
        if(tOrgVo == null){
            throw new BadRequestException("参数对象不能为空");
        }
        // 非空验证：ID
        if(StringUtils.isBlank(tOrgVo.getId())){
            throw new BadRequestException("节点编码不能为空");
        }
        // 唯一性验证：ID
        TOrg byId = tOrgManage.getById(tOrgVo.getId());
        if(byId != null){
            throw new BadRequestException("ID已存在");
        }
        // 非空验证：名称
        if(StringUtils.isBlank(tOrgVo.getLabel())){
            throw new BadRequestException("节点名称不能为空");
        }
        // 非空验证：父节点编码
        if(StringUtils.isBlank(tOrgVo.getParentId())){
            throw new BadRequestException("父节点编码不能为空");
        }
        // 唯一性校验: 父节点必需存在
        if(!tOrgManage.ROOT_NODE.equals(tOrgVo.getParentId())){
            TOrg byParentId = tOrgManage.getById(tOrgVo.getParentId());
            if(byParentId == null){
                throw new BadRequestException("父节点不存在");
            }
        }
        // 唯一性校验： 父节点下不能有同名子节点
        TOrg byParentIdAndLabel = tOrgManage.getByParentIdAndLabel(tOrgVo.getParentId(), tOrgVo.getLabel());
        if(byParentIdAndLabel != null){
            throw new BadRequestException("相同父节点下不能有同名的子节点");
        }
    }

    /**
     * 验证：编辑接口
     * @param tOrgVo
     */
    public void updateValid(TOrgVo tOrgVo){
        // 参数对象
        if(tOrgVo == null){
            throw new BadRequestException("参数对象不能为空");
        }
        // 非空验证：编码
        if(StringUtils.isBlank(tOrgVo.getId())){
            throw new BadRequestException("节点编码不能为空");
        }
        // 非空验证：编码必需存在
        TOrg byId = tOrgManage.getById(tOrgVo.getId());
        if(byId == null){
            throw new BadRequestException("编码不存在");
        }
        // 唯一性校验: 父节点必需存在
        if(!tOrgManage.ROOT_NODE.equals(tOrgVo.getParentId())){
            TOrg byParentId = tOrgManage.getById(tOrgVo.getParentId());
            if(byParentId == null){
                throw new BadRequestException("父节点不存在");
            }
        }

        // 唯一性校验： 父节点下不能有同名子节点
        if(StringUtils.isNotBlank(tOrgVo.getLabel()) && !tOrgVo.getLabel().equals(byId.getLabel())){
            String parentId = null;
            if(StringUtils.isNotBlank(tOrgVo.getParentId())){
                parentId = tOrgVo.getParentId();
            }else{
                parentId = byId.getParentId();
            }
            TOrg byParentIdAndLabel = tOrgManage.getByParentIdAndLabel(parentId, tOrgVo.getLabel());
            if(byParentIdAndLabel != null){
                throw new BadRequestException("相同父节点下不能有同名的子节点");
            }
        }
    }

    /**
     * 验证：删除接口
     * @param id
     */
    public void deleteValid(String id){
        if(StringUtils.isBlank(id)){
            throw new BadRequestException("编码不能为空");
        }
    }

    /**
     * 验证：编码查询接口
     * @param id
     */
    public void getByIdValid(String id){
        if(StringUtils.isBlank(id)){
            throw new BadRequestException("编码不能为空");
        }
    }

}
