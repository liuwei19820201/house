package com.jzfq.house.swagger.api.pc;

import com.jzfq.house.exception.TouchCodeException;
import com.jzfq.house.model.TouchResponseModel;
import com.jzfq.house.model.req.HouseReq;
import com.jzfq.house.model.req.HouseSearch;
import com.jzfq.house.model.req.PageReq;
import com.jzfq.house.model.res.HouseRes;
import com.jzfq.house.model.res.ListResultRes;
import com.jzfq.house.service.HouseService;
import com.jzfq.house.swagger.model.TouchApiResponse;
import io.swagger.annotations.ApiOperation;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

/**
 * @Title: HouseController
 * @Company: 北京桔子分期电子商务有限公司
 * @Author Li Zhe lizhe@juzifenqi.com
 * @Date 2018年09月06日 14:01
 * @Description:
 */
@Slf4j
@RestController
@RequestMapping(value = "/pc/house")
public class HouseController {

    @Autowired
    private HouseService houseService;

    @ApiOperation(value = "PC获取房源信息列表")
    @RequestMapping(value = "/list", method = RequestMethod.POST)
    public ResponseEntity<TouchResponseModel> list(@RequestBody PageReq<HouseSearch> search) {
        try {
            ListResultRes<HouseRes> result = houseService.list(search.getPage(), search.getPageSize(), search.getSearch());
            return TouchApiResponse.success(result, "获取成功");
        } catch (TouchCodeException te) {
            log.error("PC房源添加异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getMessage());
        } catch (Exception e) {
            log.error("PC房源添加异常:{}", e.getMessage());
            return TouchApiResponse.failed("房源添加失败：" + e.getMessage());
        }
    }


    @ApiOperation(value = "PC修改房源信息")
    @RequestMapping(value = "/update", method = RequestMethod.POST)
    public ResponseEntity<TouchResponseModel> updateHouse(@RequestBody @Validated({HouseReq.UpdateValidation.class}) HouseReq house) {
        try {
            houseService.update(house);
            return TouchApiResponse.success("房源修改成功");
        } catch (TouchCodeException te) {
            log.error("PC房源修异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getMessage());
        } catch (Exception e) {
            log.error("PC房源修异常:{}", e.getMessage());
            return TouchApiResponse.failed("房源修失败：" + e.getMessage());
        }
    }


    @ApiOperation(value = "PC房源装修完成")
    @RequestMapping(value = "/renovationComplete/{houseId}", method = RequestMethod.GET)
    public ResponseEntity<TouchResponseModel> renovationComplete(@PathVariable("houseId") Integer houseId) {
        try {
            houseService.renovationComplete(houseId);
            return TouchApiResponse.success("操作成功");
        } catch (TouchCodeException te) {
            log.error("PC房源装修完成异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getMessage());
        } catch (Exception e) {
            log.error("PC房源装修完成常:{}", e.getMessage());
            return TouchApiResponse.failed("操作失败：" + e.getMessage());
        }
    }

    @ApiOperation(value = "PC删除房源信息")
    @RequestMapping(value = "/delete/{houseId}", method = RequestMethod.GET)
    public ResponseEntity<TouchResponseModel> deleteHouse(@PathVariable("houseId") Integer houseId) {
        try {
            houseService.delete(houseId);
            return TouchApiResponse.success("房源删除成功");
        } catch (TouchCodeException te) {
            log.error("PC房源删除异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getMessage());
        } catch (Exception e) {
            log.error("PC房源删除异常:{}", e.getMessage());
            return TouchApiResponse.failed("房源删除失败：" + e.getMessage());
        }
    }

}
