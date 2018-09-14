package com.jzfq.house.swagger.api.sys;

import com.jzfq.house.mybatis.domain.TOrgDTO;
import com.jzfq.house.service.TOrgManage;
import com.jzfq.house.swagger.model.BaseModel;
import com.jzfq.house.swagger.model.ResponseModel;
import com.jzfq.house.valid.TOrgValid;
import io.swagger.annotations.ApiOperation;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping(value = "/foreign")
public class ForeignController extends BaseModel {
    @Autowired
    TOrgValid tOrgValid;
    @Autowired
    TOrgManage tOrgManage;

    @ApiOperation(value = "刷新整棵树的缓存", notes = "刷新整棵树的缓存")
    @RequestMapping(value = "/tOrg/refreshTree", method = RequestMethod.GET, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    ResponseEntity<ResponseModel> refreshTree(){
        TOrgDTO tree = tOrgManage.refreshTreeRedis(tOrgManage.getTreeByDB(tOrgManage.ROOT_NODE));
        return new ResponseEntity<ResponseModel>(successModel("查询", tree), HttpStatus.OK);
    }

}
