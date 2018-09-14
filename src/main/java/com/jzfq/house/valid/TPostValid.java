package com.jzfq.house.valid;

import com.jzfq.house.exception.BadRequestException;
import com.jzfq.house.mybatis.domain.TOrg;
import com.jzfq.house.mybatis.domain.TPost;
import com.jzfq.house.service.TOrgManage;
import com.jzfq.house.service.TPostManage;
import com.jzfq.house.swagger.model.TPostVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class TPostValid {

    @Autowired
    TOrgManage tOrgManage;
    @Autowired
    TPostManage tPostManage;


    /**
     * 验证：新增接口
     * @param tPostVo
     */
    public void saveValid(TPostVo tPostVo){
        // 非空验证：参数对象
        if(tPostVo == null){
            throw new BadRequestException("参数对象不能为空");
        }
        // 非空验证：编码
        if(StringUtils.isBlank(tPostVo.getId())){
            throw new BadRequestException("节点ID不能为空");
        }
        // 非空验证：名称
        if(StringUtils.isBlank(tPostVo.getLabel())){
            throw new BadRequestException("节点名称不能为空");
        }
        // 非空验证：组织编码
        if(StringUtils.isBlank(tPostVo.getOrgId())){
            throw new BadRequestException("组织ID不能为空");
        }
        // 唯一性校验: 组织ID必需存在
        if(!tOrgManage.ROOT_NODE.equals(tPostVo.getOrgId())){
            TOrg tOrg = tOrgManage.getById(tPostVo.getOrgId());
            if(tOrg == null){
                throw new BadRequestException("组织ID不存在");
            }
        }
        // 唯一性校验： 相同组织下不能有同名岗位
        TPost byOrgIdAndLabel = tPostManage.getByOrgIdAndLabel(tPostVo.getOrgId(), tPostVo.getLabel());
        if(byOrgIdAndLabel != null){
            throw new BadRequestException("相同组织下不能有同名的岗位");
        }
    }

    /**
     * 验证：编辑接口
     * @param tPostVo
     */
    public void updateValid(TPostVo tPostVo){
        // 参数对象
        if(tPostVo == null){
            throw new BadRequestException("参数对象不能为空");
        }
        // 非空验证：编码
        if(StringUtils.isBlank(tPostVo.getId())){
            throw new BadRequestException("节点ID不能为空");
        }
        // 非空验证：编码必需存在
        TPost byId = tPostManage.getById(tPostVo.getId());
        if(byId == null){
            throw new BadRequestException("ID不存在");
        }
        // 唯一性校验: 组织编码必需存在
        if(!tOrgManage.ROOT_NODE.equals(tPostVo.getOrgId())){
            TOrg tOrg = tOrgManage.getById(tPostVo.getOrgId());
            if(tOrg == null){
                throw new BadRequestException("组织ID不存在");
            }
        }

        // 唯一性校验： 相同组织下不能有同名岗位
        if(StringUtils.isNotBlank(tPostVo.getLabel()) && !tPostVo.getLabel().equals(byId.getLabel())){
            String orgId = null;
            if(StringUtils.isNotBlank(tPostVo.getOrgId())){
                orgId = tPostVo.getOrgId();
            }else{
                orgId = byId.getOrgId();
            }
            TPost byOrgIdAndLabel = tPostManage.getByOrgIdAndLabel(orgId, tPostVo.getLabel());
            if(byOrgIdAndLabel != null){
                throw new BadRequestException("相同组织下不能有同名的岗位");
            }
        }
    }

    /**
     * 验证：删除接口
     * @param id
     */
    public void deleteValid(String id){
        if(StringUtils.isBlank(id)){
            throw new BadRequestException("ID不能为空");
        }
    }

    /**
     * 验证：编码查询接口
     * @param id
     */
    public void getByIdValid(String id){
        if(StringUtils.isBlank(id)){
            throw new BadRequestException("ID不能为空");
        }
    }

}
