package com.jzfq.house.swagger.api.amp;

import com.jzfq.house.exception.TouchCodeException;
import com.jzfq.house.model.TouchResponseModel;
import com.jzfq.house.model.req.HouseReq;
import com.jzfq.house.model.res.HouseRes;
import com.jzfq.house.service.HouseService;
import com.jzfq.house.swagger.model.BaseModel;
import com.jzfq.house.swagger.model.TouchApiResponse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

@Slf4j
@RestController
@RequestMapping(value = "/amp")
public class AmpController extends BaseModel {

    @Autowired
    private HouseService houseService;

    @ApiOperation(value = "添加房源信息")
    @RequestMapping(value = "/house/create", method = RequestMethod.POST)
    public ResponseEntity<TouchResponseModel> createHouse(@RequestBody @Validated HouseReq house) {
        try {
            houseService.create(house);
            return TouchApiResponse.success("房源添加成功");
        } catch (TouchCodeException te) {
            log.error("房源添加异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getMessage());
        } catch (Exception e) {
            log.error("房源添加异常:{}", e.getMessage());
            return TouchApiResponse.failed("房源添加失败：" + e.getMessage());
        }
    }

    @ApiOperation(value = "修改房源信息")
    @RequestMapping(value = "/house/update", method = RequestMethod.POST)
    public ResponseEntity<TouchResponseModel> updateHouse(@RequestBody @Validated({HouseReq.UpdateValidation.class}) HouseReq house) {
        try {
            houseService.update(house);
            return TouchApiResponse.success("房源修改成功");
        } catch (TouchCodeException te) {
            log.error("房源修异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getMessage());
        } catch (Exception e) {
            log.error("房源修异常:{}", e.getMessage());
            return TouchApiResponse.failed("房源修失败：" + e.getMessage());
        }
    }

    @ApiOperation(value = "通过编号ID获取房源信息")
    @RequestMapping(value = "/house/get/{houseId}", method = RequestMethod.GET)
    public ResponseEntity<TouchResponseModel> getHouse(@PathVariable("houseId") Integer houseId) {
        try {
            HouseRes res = houseService.getById(houseId);
            return TouchApiResponse.success(res, "获取成功");
        } catch (TouchCodeException te) {
            log.error("通过编号ID获取房源信息异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getMessage());
        } catch (Exception e) {
            log.error("通过编号ID获取房源信息异常:{}", e.getMessage());
            return TouchApiResponse.failed("获取失败：" + e.getMessage());
        }
    }


}
