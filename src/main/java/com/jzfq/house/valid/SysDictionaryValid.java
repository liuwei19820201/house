package com.jzfq.house.valid;

import com.jzfq.house.exception.BadRequestException;
import com.jzfq.house.mybatis.domain.SysDictionary;
import com.jzfq.house.service.SysDictionaryManage;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class SysDictionaryValid {

    @Autowired
    SysDictionaryManage sysDictionaryManage;

    /**
     * 验证：新增接口
     * @param sysDictionary
     */
    public void saveValid(SysDictionary sysDictionary){
        // 非空验证：参数对象
        if(sysDictionary == null){
            throw new BadRequestException("参数对象不能为空");
        }
        // 非空验证：父节点
        if(sysDictionary.getParentId() == null){
            throw new BadRequestException("父节点不能为空");
        }
        // 正确性校验: 父节点必需存在
        SysDictionary byParentId = sysDictionaryManage.findById(sysDictionary.getParentId());
        if(byParentId == null){
            throw new BadRequestException("父节点不存在");
        }
        // 非空验证：节点编码
        if(StringUtils.isBlank(sysDictionary.getCode())){
            throw new BadRequestException("节点编码不能为空");
        }
        // 唯一性校验：节点编码
        if(sysDictionaryManage.getByCode(sysDictionary.getCode()) != null){
            throw new BadRequestException("节点编码已存在");
        }
        // 非空验证：节点名称
        if(StringUtils.isBlank(sysDictionary.getLabel())){
            throw new BadRequestException("节点名称不能为空");
        }
        // 唯一性校验： 父节点下不能有同名子节点
        SysDictionary byParentIdAndLabel = sysDictionaryManage.getByParentIdAndLabel(sysDictionary.getParentId(), sysDictionary.getLabel());
        if(byParentIdAndLabel != null){
            throw new BadRequestException("相同父节点下不能有同名的子节点");
        }
    }

    /**
     * 验证：编辑接口
     * @param sysDictionary
     */
    public void updateValid(SysDictionary sysDictionary){
        // 参数对象
        if(sysDictionary == null){
            throw new BadRequestException("参数对象不能为空");
        }
        // 非空验证：ID不能为空
        if(sysDictionary.getId() == null){
            throw new BadRequestException("ID不能为空");
        }
        // 非空验证：ID必需存在
        SysDictionary byId = sysDictionaryManage.findById(sysDictionary.getId());
        if(byId == null){
            throw new BadRequestException("ID不存在");
        }
        // 唯一性校验: 父节点必需存在
        if(sysDictionary.getParentId() != -1){
            SysDictionary byParentId = sysDictionaryManage.findById(sysDictionary.getParentId());
            if(byParentId == null){
                throw new BadRequestException("父节点不存在");
            }
        }

        // 唯一性校验： 父节点下不能有同名子节点
        if(StringUtils.isNotBlank(sysDictionary.getLabel()) && !sysDictionary.getLabel().equals(byId.getLabel())){
            Long parentId = null;
            if(sysDictionary.getParentId() != null){
                parentId = sysDictionary.getParentId();
            }else{
                parentId = byId.getParentId();
            }
            SysDictionary byParentIdAndLabel = sysDictionaryManage.getByParentIdAndLabel(parentId, sysDictionary.getLabel());
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
