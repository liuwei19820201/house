package com.jzfq.house.swagger.api.pc;

import com.jzfq.house.service.AreaManage;
import com.jzfq.house.swagger.model.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;
import java.util.Map;

@RestController
@RequestMapping(value = "/api/areaBusi")
public class AreaController extends BaseModel {
    @Autowired
    AreaManage areaManage;

    @ApiOperation(value = "分页查询", notes = "分页查询")
    @RequestMapping(value = "/page", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> getPage(AreaSearch areaSearch){
        List<Map<String, Object>> list = areaManage.getPage(areaSearch);
        int totalCount = areaManage.getPageCount(areaSearch);
        return new ResponseEntity<>(successModel("查询",page(list, totalCount)), HttpStatus.OK);
    }

    @ApiOperation(value = "新增", notes = "新增 ")
    @RequestMapping(value = "/save", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> save(@RequestBody AreaVo areaVo){
        if(areaManage.save(areaVo)){
            return new ResponseEntity<>(successModel(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(badRequestModel(), HttpStatus.OK);
        }
    }

    @ApiOperation(value = "编辑", notes = "编辑")
    @RequestMapping(value = "/update", method = RequestMethod.PUT, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> update(@RequestBody AreaVo areaVo){
        if(areaManage.update(areaVo)){
            return new ResponseEntity<>(successModel(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(badRequestModel(), HttpStatus.OK);
        }
    }

    @ApiOperation(value = "删除", notes = "删除")
    @RequestMapping(value = "/delete", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> delete(@ApiParam(value = "主键") @Valid @RequestParam(value = "id", required = true) Integer id){
        if(areaManage.removeById(id) == 1){
            return new ResponseEntity<>(successModel(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(badRequestModel(), HttpStatus.OK);
        }
    }

    @ApiOperation(value = "批量删除",notes = "批量删除")
    @RequestMapping(value = "/remove", method = RequestMethod.DELETE, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> remove(@ApiParam(value = "主键拼串") @Valid @RequestParam(value = "ids", required = true) String ids){
        String failMsg = areaManage.batchRemove(ids);
        if(StringUtils.isBlank(failMsg)){
            return new ResponseEntity<>(successModel(), HttpStatus.OK);
        }else{
            return new ResponseEntity<>(badRequestModel(failMsg), HttpStatus.OK);
        }
    }


}
