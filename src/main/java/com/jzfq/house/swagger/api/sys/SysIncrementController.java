package com.jzfq.house.swagger.api.sys;

import com.jzfq.house.code.Increment;
import com.jzfq.house.code.IncrementHandler;
import com.jzfq.house.code.IncrementSearch;
import com.jzfq.house.swagger.model.BaseModel;
import com.jzfq.house.swagger.model.ResponseModel;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.java.Log;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@Log
@RestController
@RequestMapping(value = "/api/sysIncrement")
public class SysIncrementController extends BaseModel {
    @Value("${increment.path}")
    private String INCREMENT_PATH;

    @Autowired
    IncrementHandler incrementHandler;

    @ApiOperation(value = "新增", notes = "新增 ")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> save(@RequestBody Increment increment){
        incrementHandler.save(increment, INCREMENT_PATH);
        return new ResponseEntity<ResponseModel>(successModel(), HttpStatus.OK);
    }

    @ApiOperation(value = "修改", notes = "修改")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> update(@RequestBody Increment increment){
        incrementHandler.update(increment, INCREMENT_PATH);
        return new ResponseEntity<ResponseModel>(successModel(), HttpStatus.OK);
    }

    @ApiOperation(value = "删除", notes = "删除")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> delete(@ApiParam(value = "名称") @Valid @RequestParam(value = "id", required = true) String name){
        incrementHandler.delete(name, INCREMENT_PATH);
        return new ResponseEntity<ResponseModel>(successModel(), HttpStatus.OK);
    }

    @ApiOperation(value = "批量删除",notes = "批量删除")
    @RequestMapping(value = "/remove", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> remove(@ApiParam(value = "主键拼串") @Valid @RequestParam(value = "ids", required = true) String names){
        String failMsg = incrementHandler.batchRemove(names, INCREMENT_PATH);
        if(StringUtils.isBlank(failMsg)){
            return new ResponseEntity<ResponseModel>(successModel(), HttpStatus.OK);
        }else{
            return new ResponseEntity<ResponseModel>(badRequestModel(failMsg), HttpStatus.OK);
        }
    }

    @ApiOperation(value = "查询", notes = "查询")
    @RequestMapping(value = "/get", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> get(@ApiParam(value = "名称") @Valid @RequestParam(value = "name", required = true) String name){
        Increment increment = incrementHandler.get(name, INCREMENT_PATH);
        return new ResponseEntity<ResponseModel>(successModel(increment), HttpStatus.OK);
    }

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @RequestMapping(value = "/page", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> getByPage(IncrementSearch incrementSearch){
        List<Increment> list = incrementHandler.getByPage(incrementSearch, INCREMENT_PATH);
        int totalCount = incrementHandler.getPageCount(incrementSearch, INCREMENT_PATH);
        return new ResponseEntity<ResponseModel>(successModel("查询",page(list, totalCount)), HttpStatus.OK);
    }

    @ApiOperation(value = "消费", notes = "消费")
    @RequestMapping(value = "/consume", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> consume(@ApiParam(value = "名称") @Valid @RequestParam(value = "name", required = true) String name){
        incrementHandler.consume(name, INCREMENT_PATH);
        return new ResponseEntity<ResponseModel>(successModel("消费"), HttpStatus.OK);
    }


}
