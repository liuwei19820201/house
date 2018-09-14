package com.jzfq.house.swagger.api.sys;

import com.jzfq.house.code.Tid;
import com.jzfq.house.mybatis.domain.TOrg;
import com.jzfq.house.mybatis.domain.TOrgDTO;
import com.jzfq.house.service.TOrgManage;
import com.jzfq.house.swagger.model.BaseModel;
import com.jzfq.house.swagger.model.ResponseModel;
import com.jzfq.house.swagger.model.TOrgVo;
import com.jzfq.house.util.TransferUtil;
import com.jzfq.house.valid.TOrgValid;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/tOrg")
public class TOrgController extends BaseModel {
    @Autowired
    Tid tid;
    @Autowired
    TOrgValid tOrgValid;
    @Autowired
    TOrgManage tOrgManage;

    @ApiOperation(value = "获取新的组织ID", notes = "获取新的组织ID")
    @RequestMapping(value = "/getId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> getId(){
        String id = tid.getTOrgId();
        return new ResponseEntity<ResponseModel>(successModel("查询", id), HttpStatus.OK);
    }

    @ApiOperation(value = "查询整棵树", notes = "查询整棵树")
    @RequestMapping(value = "/getTree", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> getTree(){
        TOrgDTO tree = tOrgManage.getTree();
        return new ResponseEntity<ResponseModel>(successModel("查询", tree), HttpStatus.OK);
    }

    @ApiOperation(value = "新增", notes = "新增 ")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> save(@RequestBody TOrgVo tOrgVo){
        tOrgValid.saveValid(tOrgVo);
        boolean save = tOrgManage.save(tOrgVo);
        if(save){
            return new ResponseEntity<ResponseModel>(successModel(), HttpStatus.OK);
        }else{
            return new ResponseEntity<ResponseModel>(badRequestModel(), HttpStatus.OK);
        }
    }

    @ApiOperation(value = "编辑", notes = "编辑")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> update(@RequestBody TOrgVo tOrgVo){
        tOrgValid.updateValid(tOrgVo);
        boolean update = tOrgManage.update(tOrgVo);
        if(update){
            return new ResponseEntity<ResponseModel>(successModel(), HttpStatus.OK);
        }else{
            return new ResponseEntity<ResponseModel>(badRequestModel(), HttpStatus.OK);
        }
    }

    @ApiOperation(value = "删除", notes = "删除")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> delete(@ApiParam(value = "主键") @Valid @RequestParam(value = "ids", required = false) String ids){
        for(String id : ids.split(",")){
            tOrgValid.deleteValid(id);
        }
        int i = tOrgManage.deleteMulti(ids);
        return new ResponseEntity<ResponseModel>(successModel().data("删除节点数量："+i), HttpStatus.OK);
    }

    @ApiOperation(value = "编码查询", notes = "编码查询")
    @RequestMapping(value = "/getById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> getById(@ApiParam(value = "编码查询") @Valid @RequestParam(value = "id", required = false) String id){
        tOrgValid.getByIdValid(id);
        TOrg tOrg = tOrgManage.getById(id);
        TOrgDTO tOrgDTO = new TOrgDTO();
        TransferUtil.transfer(tOrgDTO, tOrg);
        return new ResponseEntity<ResponseModel>(successModel("查询", tOrgDTO), HttpStatus.OK);
    }
}
