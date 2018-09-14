package com.jzfq.house.swagger.api.mp;

import com.jzfq.house.exception.TouchCodeException;
import com.jzfq.house.model.TouchResponseModel;
import com.jzfq.house.model.req.PageReq;
import com.jzfq.house.model.res.ListResultRes;
import com.jzfq.house.mybatis.domain.*;
import com.jzfq.house.service.*;
import com.jzfq.house.swagger.model.BaseModel;
import com.jzfq.house.swagger.model.TouchApiResponse;
import com.jzfq.house.swagger.model.amp.*;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiParam;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.cache.annotation.Cacheable;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.ws.rs.core.MediaType;
import java.util.List;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping(value = "/mpres")
public class MpResRecordController extends BaseModel {

    final String RES_RECORD_ALL = "res_record_all";

    private static final String RES_RECORD_LIST = "/resRecordList"; // 资源记录列表
    private static final String RES_RECORD_LIST_PAGE = "/resRecordListPage"; // 资源记录列表分页
    private static final String SAVE_RESOURCES_RECORD = "/saveResourcesRecord"; // 添加资源
    private static final String DEL_RESOURCES_RECORD = "/delResourcesRecord"; // 删除资源
    private static final String DEL_REQ_RECORD = "/delReqRecord"; // 删除请款记录
    private static final String ADD_REQ_RECORD = "/addReqRecord"; // 添加请款记录
    private static final String ADD_PAY_RECORD = "/addPayRecord"; // 添加付款记录

    @Autowired
    private ResourceRecordService resourceRecordService;

    @Autowired
    private ReqRecordService reqRecordService;

    @Autowired
    private PayRecordService payRecordService;
    /**
     * 资源记录列表
     * @param req
     * @return
     */
    @ApiOperation(value = "资源记录列表")
    @RequestMapping(value = RES_RECORD_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    @Cacheable(value = RES_RECORD_ALL, key = RES_RECORD_ALL)
    public ResponseEntity<TouchResponseModel> projectList(@RequestBody ResourcesRecordReq req) {
        try {
            List<Map<String, Object>> list = resourceRecordService.findListAll(req);
            return TouchApiResponse.success(list,"查询项目列表成功");
        } catch (TouchCodeException te) {
            log.error("请求返回异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getTouchApiCode().getMsg() + te.getExtendMsg());
        } catch (Exception e) {
            log.error(e.getMessage());
            return TouchApiResponse.failed(e.getMessage());
        }

    }

    /**
     * 资源记录列表分页
     * @param req
     * @return
     */
    @ApiOperation(value = "资源记录列表分页")
    @RequestMapping(value = RES_RECORD_LIST_PAGE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    @Cacheable(value = RES_RECORD_ALL, key = RES_RECORD_ALL)
    public ResponseEntity<TouchResponseModel> projectListPage(@ApiParam(value = "页码") @RequestParam(value = "page", required = false) Integer page,
                                                              @ApiParam(value = "每页数量") @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestBody ResourcesRecordReq req) {
        PageReq<ResourcesRecordReq> pageReq = new PageReq<>(page, pageSize, req);
        try {
            ListResultRes<Map<String, Object>> result = resourceRecordService.getList(pageReq.getPage(), pageReq.getPageSize(), req);
            return TouchApiResponse.success(result,"操作成功");
        } catch (TouchCodeException te) {
            log.error("请求返回异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getTouchApiCode().getMsg() + te.getExtendMsg());
        } catch (Exception e) {
            log.error(e.getMessage());
            return TouchApiResponse.failed(e.getMessage());
        }
    }


    /**
     * 添加资源
     * @param req
     * @return
     */
    @ApiOperation(value = "添加资源")
    @RequestMapping(value = SAVE_RESOURCES_RECORD, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<TouchResponseModel> createProject(@RequestBody ResourcesRecordReq req) throws Exception {
        try {
            resourceRecordService.save(req);
            return TouchApiResponse.success("操作成功");
        } catch (TouchCodeException te) {
            log.error("请求返回异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getTouchApiCode().getMsg() + te.getExtendMsg());
        } catch (Exception e) {
            return TouchApiResponse.failed(e.getMessage());
        }
    }

    /**
     * 删除资源
     * @param req
     * @return
     */
    @ApiOperation(value = "删除资源")
    @RequestMapping(value = DEL_RESOURCES_RECORD, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<TouchResponseModel> delProject(@RequestBody ResourcesRecordReq req) throws Exception {
        try {
            resourceRecordService.delete(req);
            return TouchApiResponse.success("操作成功");
        } catch (TouchCodeException te) {
            log.error("请求返回异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getTouchApiCode().getMsg() + te.getExtendMsg());
        } catch (Exception e) {
            return TouchApiResponse.failed(e.getMessage());
        }
    }

    /**
     * 删除请款记录
     * @param req
     * @return
     */
    @ApiOperation(value = "删除请款记录")
    @RequestMapping(value = DEL_REQ_RECORD, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<TouchResponseModel> delReqRecord(@RequestBody ReqRecordReq req) throws Exception {
        try {
            reqRecordService.delete(req);
            return TouchApiResponse.success("操作成功");
        } catch (TouchCodeException te) {
            log.error("请求返回异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getTouchApiCode().getMsg() + te.getExtendMsg());
        } catch (Exception e) {
            return TouchApiResponse.failed(e.getMessage());
        }
    }

    /**
     * 添加请款记录
     * @param req
     * @return
     */
    @ApiOperation(value = "添加请款记录")
    @RequestMapping(value = ADD_REQ_RECORD, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<TouchResponseModel> addReqRecord(@RequestBody ReqRecordReq req) throws Exception {
        try {
            reqRecordService.save(req);
            return TouchApiResponse.success("操作成功");
        } catch (TouchCodeException te) {
            log.error("请求返回异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getTouchApiCode().getMsg() + te.getExtendMsg());
        } catch (Exception e) {
            return TouchApiResponse.failed(e.getMessage());
        }
    }

    /**
     * 添加付款记录
     * @param req
     * @return
     */
    @ApiOperation(value = "添加付款记录")
    @RequestMapping(value = ADD_PAY_RECORD, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<TouchResponseModel> addPayRecord(@RequestBody PayRecordReq req) throws Exception {
        try {
            payRecordService.save(req);
            return TouchApiResponse.success("操作成功");
        } catch (TouchCodeException te) {
            log.error("请求返回异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getTouchApiCode().getMsg() + te.getExtendMsg());
        } catch (Exception e) {
            return TouchApiResponse.failed(e.getMessage());
        }
    }
}
