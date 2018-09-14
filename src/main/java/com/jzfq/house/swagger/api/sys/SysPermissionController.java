package com.jzfq.house.swagger.api.sys;

import com.jzfq.house.mybatis.domain.SysPermission;
import com.jzfq.house.mybatis.domain.SysPermissionDTO;
import com.jzfq.house.service.SysPermissionManage;
import com.jzfq.house.swagger.model.BaseModel;
import com.jzfq.house.swagger.model.ResponseModel;
import com.jzfq.house.util.TransferUtil;
import com.jzfq.house.valid.SysPermissionValid;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping(value = "/api/sysPermission")
public class SysPermissionController extends BaseModel {
    @Autowired
    SysPermissionValid sysPermissionValid;
    @Autowired
    SysPermissionManage sysPermissionManage;

    @ApiOperation(value = "查询整棵树", notes = "查询整棵树")
    @RequestMapping(value = "/getTree", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> getTree(){
        SysPermissionDTO sysPermissionDTO = sysPermissionManage.getTree();
        return new ResponseEntity<ResponseModel>(successModel("查询", sysPermissionDTO), HttpStatus.OK);
    }

    @ApiOperation(value = "新增", notes = "新增 ")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> save(@RequestBody SysPermission sysPermission){
        sysPermissionValid.saveValid(sysPermission);
        boolean save = sysPermissionManage.save(sysPermission);
        if(save){
            return new ResponseEntity<ResponseModel>(successModel(), HttpStatus.OK);
        }else{
            return new ResponseEntity<ResponseModel>(badRequestModel(), HttpStatus.OK);
        }
    }

    @ApiOperation(value = "编辑", notes = "编辑")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> update(@RequestBody List<SysPermission> sysPermissionList){
        for(SysPermission sysPermission : sysPermissionList){
            sysPermissionValid.updateValid(sysPermission);
        }
        int i = sysPermissionManage.updateMulti(sysPermissionList);
        return new ResponseEntity<ResponseModel>(successModel().data("修改节点数量："+i), HttpStatus.OK);
    }

    @ApiOperation(value = "删除", notes = "删除")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> delete(@ApiParam(value = "主键") @Valid @RequestParam(value = "ids", required = false) String ids){
        for(String idStr : ids.split(",")){
            sysPermissionValid.deleteValid(Long.parseLong(idStr));
        }
        int i = sysPermissionManage.deleteMulti(ids);
        return new ResponseEntity<ResponseModel>(successModel().data("删除节点数量："+i), HttpStatus.OK);
    }

    @ApiOperation(value = "ID查询", notes = "ID查询")
    @RequestMapping(value = "/getById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> getById(@ApiParam(value = "ID查询") @Valid @RequestParam(value = "id", required = false) Long id){
        SysPermission sysPermission = sysPermissionManage.findById(id);
        SysPermissionDTO sysPermissionDTO = new SysPermissionDTO();
        TransferUtil.transfer(sysPermissionDTO, sysPermission);
        return new ResponseEntity<ResponseModel>(successModel("查询", sysPermissionDTO), HttpStatus.OK);
    }
}
