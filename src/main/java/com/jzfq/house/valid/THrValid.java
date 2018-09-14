package com.jzfq.house.valid;

import com.jzfq.house.exception.BadRequestException;
import com.jzfq.house.mybatis.domain.THr;
import com.jzfq.house.mybatis.domain.TOrg;
import com.jzfq.house.service.THrManage;
import com.jzfq.house.service.TOrgManage;
import com.jzfq.house.service.TPostManage;
import com.jzfq.house.swagger.model.THrVo;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class THrValid {

    @Autowired
    TOrgManage tOrgManage;
    @Autowired
    TPostManage tPostManage;
    @Autowired
    THrManage tHrManage;


    /**
     * 验证：新增接口
     * @param tHrVo
     */
    public void saveValid(THrVo tHrVo){
        // 非空验证：参数对象
        if(tHrVo == null){
            throw new BadRequestException("参数对象不能为空");
        }
        // 非空验证：编码
        if(StringUtils.isBlank(tHrVo.getId())){
            throw new BadRequestException("节点编码不能为空");
        }
        // 非空验证：名称
        if(StringUtils.isBlank(tHrVo.getLabel())){
            throw new BadRequestException("节点名称不能为空");
        }
        // 非空验证：组织编码
        if(StringUtils.isBlank(tHrVo.getOrgId())){
            throw new BadRequestException("组织编码不能为空");
        }
        // 唯一性校验: 组织编码必需存在
        if(!tOrgManage.ROOT_NODE.equals(tHrVo.getOrgId())){
            TOrg tOrg = tOrgManage.getById(tHrVo.getOrgId());
            if(tOrg == null){
                throw new BadRequestException("组织编码不存在");
            }
        }
    }

    /**
     * 验证：编辑接口
     * @param tHrVo
     */
    public void updateValid(THrVo tHrVo){
        // 参数对象
        if(tHrVo == null){
            throw new BadRequestException("参数对象不能为空");
        }
        // 非空验证：编码
        if(StringUtils.isBlank(tHrVo.getId())){
            throw new BadRequestException("节点编码不能为空");
        }
        // 非空验证：编码必需存在
        THr byId = tHrManage.getById(tHrVo.getId());
        if(byId == null){
            throw new BadRequestException("编码不存在");
        }
        // 唯一性校验: 组织编码必需存在
        if(!tOrgManage.ROOT_NODE.equals(tHrVo.getOrgId())){
            TOrg tOrg = tOrgManage.getById(tHrVo.getOrgId());
            if(tOrg == null){
                throw new BadRequestException("组织编码不存在");
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
