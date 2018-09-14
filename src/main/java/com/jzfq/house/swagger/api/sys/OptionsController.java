package com.jzfq.house.swagger.api.sys;

import com.jzfq.house.service.OptionManage;
import com.jzfq.house.swagger.model.BaseModel;
import com.jzfq.house.swagger.model.Option;
import com.jzfq.house.swagger.model.ResponseModel;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
@RequestMapping(value = "/api/option")
public class OptionsController extends BaseModel {
    @Autowired
    OptionManage optionManage;


    @ApiOperation(value = "ICON", notes = "ICON")
    @RequestMapping(value = "/icon", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> getIcons(){
        List<Option> icons = optionManage.getIcons();
        return new ResponseEntity<ResponseModel>(successModel("查询", icons), HttpStatus.OK);
    }

}
