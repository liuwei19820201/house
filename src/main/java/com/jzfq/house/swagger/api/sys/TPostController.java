package com.jzfq.house.swagger.api.sys;

import com.jzfq.house.code.Tid;
import com.jzfq.house.mybatis.domain.TPost;
import com.jzfq.house.mybatis.domain.TPostDTO;
import com.jzfq.house.service.TPostManage;
import com.jzfq.house.swagger.model.BaseModel;
import com.jzfq.house.swagger.model.ResponseModel;
import com.jzfq.house.swagger.model.TPostVo;
import com.jzfq.house.util.TransferUtil;
import com.jzfq.house.valid.TPostValid;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
@RequestMapping(value = "/api/tPost")
public class TPostController extends BaseModel {
    @Autowired
    Tid tid;
    @Autowired
    TPostValid tPostValid;
    @Autowired
    TPostManage tPostManage;

    @ApiOperation(value = "获取新的岗位ID", notes = "获取新的岗位ID")
    @RequestMapping(value = "/getId", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> getId(){
        String id = tid.getTPostId();
        return new ResponseEntity<ResponseModel>(successModel("查询", id), HttpStatus.OK);
    }

    @ApiOperation(value = "新增", notes = "新增 ")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> save(@RequestBody TPostVo tPostVo){
        tPostValid.saveValid(tPostVo);
        boolean save = tPostManage.save(tPostVo);
        if(save){
            return new ResponseEntity<ResponseModel>(successModel(), HttpStatus.OK);
        }else{
            return new ResponseEntity<ResponseModel>(badRequestModel(), HttpStatus.OK);
        }
    }

    @ApiOperation(value = "编辑", notes = "编辑")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> update(@RequestBody TPostVo tPostVo){
        tPostValid.updateValid(tPostVo);
        boolean update = tPostManage.update(tPostVo);
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
            tPostValid.deleteValid(id);        }
        int i = tPostManage.deleteMulti(ids);
        return new ResponseEntity<ResponseModel>(successModel().data("删除节点数量："+i), HttpStatus.OK);
    }

    @ApiOperation(value = "ID查询", notes = "ID查询")
    @RequestMapping(value = "/getById", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> getById(@ApiParam(value = "编码查询") @Valid @RequestParam(value = "id", required = false) String id){
        tPostValid.getByIdValid(id);
        TPost tPost = tPostManage.getById(id);
        TPostDTO tPostDTO = new TPostDTO();
        TransferUtil.transfer(tPostDTO, tPost);
        return new ResponseEntity<ResponseModel>(successModel("查询", tPostDTO), HttpStatus.OK);
    }
}
