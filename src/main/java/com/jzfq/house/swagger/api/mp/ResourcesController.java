package com.jzfq.house.swagger.api.mp;

import com.jzfq.house.exception.TouchCodeException;
import com.jzfq.house.model.TouchResponseModel;
import com.jzfq.house.model.req.HouseMessageReq;
import com.jzfq.house.model.req.HouseMessageSearch;
import com.jzfq.house.model.req.HouseSearch;
import com.jzfq.house.model.res.HouseMessageRes;
import com.jzfq.house.model.res.HouseRes;
import com.jzfq.house.service.HouseMessageService;
import com.jzfq.house.service.HouseService;
import com.jzfq.house.swagger.model.BaseModel;
import com.jzfq.house.swagger.model.TouchApiResponse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Slf4j
@RestController
@RequestMapping(value = "/mp/res")
public class ResourcesController extends BaseModel {

    @Autowired
    private HouseService houseService;

    @Autowired
    private HouseMessageService houseMessageService;

    @ApiOperation(value = "获取房源信息-资源列表")
    @RequestMapping(value = "/list", method = RequestMethod.GET)
    public ResponseEntity<TouchResponseModel> getHouse(HouseSearch search) {
        try {
            List<HouseRes> res = houseService.listAll(search);
            return TouchApiResponse.success(res, "获取成功");
        } catch (TouchCodeException te) {
            log.error("获取房源信息异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getMessage());
        } catch (Exception e) {
            log.error("获取房源信息异常:{}", e.getMessage());
            return TouchApiResponse.failed("获取失败：" + e.getMessage());
        }
    }

    @ApiOperation(value = "留言列表")
    @RequestMapping(value = "/messageList", method = RequestMethod.GET)
    public ResponseEntity<TouchResponseModel> messageList(HouseMessageSearch search) {
        try {
            List<HouseMessageRes> res = houseMessageService.listAll(search);
            return TouchApiResponse.success(res, "获取留言列表成功");
        } catch (TouchCodeException te) {
            log.error("获取留言列表异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getMessage());
        } catch (Exception e) {
            log.error("获取留言列表异常:{}", e.getMessage());
            return TouchApiResponse.failed("获取留言列表失败：" + e.getMessage());
        }
    }

    @ApiOperation(value = "新增管理者备注")
    @RequestMapping(value = "/addManagerRemark", method = RequestMethod.GET)
    public ResponseEntity<TouchResponseModel> addManagerRemark(HouseMessageReq req) {
        try {
           houseMessageService.create(req);
            return TouchApiResponse.success("新增管理者备注成功");
        } catch (TouchCodeException te) {
            log.error("异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getMessage());
        } catch (Exception e) {
            log.error("获取管理者列表异常:{}", e.getMessage());
            return TouchApiResponse.failed("v失败：" + e.getMessage());
        }
    }

    @ApiOperation(value = "给中介留言")
    @RequestMapping(value = "/addMessage", method = RequestMethod.POST)
    public ResponseEntity<TouchResponseModel> addMessage(HouseMessageReq req) {
        try {
            houseMessageService.create(req);
            return TouchApiResponse.success("给中介留言成功");
        } catch (TouchCodeException te) {
            log.error("给中介留言异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getMessage());
        } catch (Exception e) {
            log.error("给中介留言异常:{}", e.getMessage());
            return TouchApiResponse.failed("给中介留言失败：" + e.getMessage());
        }
    }
}
