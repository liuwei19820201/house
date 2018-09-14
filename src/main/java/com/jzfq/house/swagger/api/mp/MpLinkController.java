package com.jzfq.house.swagger.api.mp;

import com.jzfq.house.exception.TouchCodeException;
import com.jzfq.house.model.TouchResponseModel;
import com.jzfq.house.model.req.PageReq;
import com.jzfq.house.model.res.ListResultRes;
import com.jzfq.house.mybatis.domain.Person;
import com.jzfq.house.service.PersonService;
import com.jzfq.house.service.ProjectLinkService;
import com.jzfq.house.service.ProjectService;
import com.jzfq.house.swagger.model.BaseModel;
import com.jzfq.house.swagger.model.TouchApiResponse;
import com.jzfq.house.swagger.model.amp.ProjectLinkLeaderReq;
import com.jzfq.house.swagger.model.amp.ProjectLinkReq;
import com.jzfq.house.swagger.model.amp.ReqRecordReq;
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
@RequestMapping(value = "/mplink")
public class MpLinkController extends BaseModel {

    final String PROJECT_LINK_ALL = "project_link_all";
    final String PERSON_ALL = "person_all";

    private static final String LINK_LIST = "/linkList"; // 环节列表
    private static final String LINK_LIST_PAGE = "/linkListPage"; // 环节列表分页
    private static final String CREATE_PROJECT_LINK = "/createProjectLink"; // 添加环节
    private static final String PERSON_LIST = "/personList"; // 环节人员列表
    private static final String UPDATE_PROJECT_LINK_STATUS = "/updateProjectLinkStatus"; // 更新环节环节状态
    private static final String UPDATE_PROJECT_LINK_DATE = "/updateProjectLinkDate"; // 更新环节起止时间
    private static final String UPDATE_PROJECT_LINK_LEADER = "/updateProjectLinkLeader"; // 更新环节负责人
    private static final String ADD_PROJECT_LINK_LEADER = "/addProjectLinkLeader"; // 增加环节负责人
    private static final String DEL_LINK = "/delLink"; // 删除环节

    @Autowired
    private ProjectLinkService projectLinkService;

    @Autowired
    private PersonService personService;

    /**
     * 环节列表
     * @param req
     * @return
     */
    @ApiOperation(value = "环节列表")
    @RequestMapping(value = LINK_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    @Cacheable(value = PROJECT_LINK_ALL, key = PROJECT_LINK_ALL)
    public ResponseEntity<TouchResponseModel> linkList(@RequestBody ProjectLinkReq req) {
        try {
            List<Map<String, Object>> list = projectLinkService.findListAll(req);
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
     * 环节列表分页
     * @param req
     * @return
     */
    @ApiOperation(value = "环节列表分页")
    @RequestMapping(value = LINK_LIST_PAGE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    @Cacheable(value = PROJECT_LINK_ALL, key = PROJECT_LINK_ALL)
    public ResponseEntity<TouchResponseModel> linkListPage(@ApiParam(value = "页码") @RequestParam(value = "page", required = false) Integer page,
                                                              @ApiParam(value = "每页数量") @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestBody ProjectLinkReq req) {
        PageReq<ProjectLinkReq> pageReq = new PageReq<>(page, pageSize, req);
        try {
            ListResultRes<Map<String, Object>> result = projectLinkService.getList(pageReq.getPage(), pageReq.getPageSize(), req);
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
     * 添加环节
     * @param req
     * @return
     */
    @ApiOperation(value = "添加环节")
    @RequestMapping(value = CREATE_PROJECT_LINK, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<TouchResponseModel> createProjectLink(@RequestBody ProjectLinkReq req) throws Exception {
        try {
            projectLinkService.createProjectLink(req);
            return TouchApiResponse.success("操作成功");
        } catch (TouchCodeException te) {
            log.error("请求返回异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getTouchApiCode().getMsg() + te.getExtendMsg());
        } catch (Exception e) {
            return TouchApiResponse.failed(e.getMessage());
        }
    }

    /**
     * 环节人员列表
     * @param classify 分类 1责任人，2参与人，3资源对接人
     * @return
     */
    @ApiOperation(value = "环节人员列表")
    @RequestMapping(value = PERSON_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    @Cacheable(value = PERSON_ALL, key = PERSON_ALL)
    public ResponseEntity<TouchResponseModel> personList(@ApiParam(value = "分类 1责任人，2参与人，3资源对接人") @RequestParam(value = "classify", required = false) Integer classify) {
        try {
            Person person = new Person();
            person.setClassify(classify);
            List<Map<String, Object>> list = personService.findList(person);
            return TouchApiResponse.success(list,"查询环节人员列表成功");
        } catch (TouchCodeException te) {
            log.error("请求返回异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getTouchApiCode().getMsg() + te.getExtendMsg());
        } catch (Exception e) {
            log.error(e.getMessage());
            return TouchApiResponse.failed(e.getMessage());
        }
    }

    /**
     * 更新环节状态
     * @param req
     * @return
     */
    @ApiOperation(value = "更新环节状态")
    @RequestMapping(value = UPDATE_PROJECT_LINK_STATUS, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<TouchResponseModel> updateProjectLinkStatus(@RequestBody ProjectLinkReq req) throws Exception {
        try {
            projectLinkService.updateProjectLinkStatus(req);
            return TouchApiResponse.success("操作成功");
        } catch (TouchCodeException te) {
            log.error("请求返回异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getTouchApiCode().getMsg() + te.getExtendMsg());
        } catch (Exception e) {
            return TouchApiResponse.failed(e.getMessage());
        }
    }

    /**
     * 更新环节起止时间
     * @param req
     * @return
     */
    @ApiOperation(value = "更新环节起止时间")
    @RequestMapping(value = UPDATE_PROJECT_LINK_DATE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<TouchResponseModel> updateProjectLinkDate(@RequestBody ProjectLinkReq req) throws Exception {
        try {
            projectLinkService.updateProjectLinkDate(req);
            return TouchApiResponse.success("操作成功");
        } catch (TouchCodeException te) {
            log.error("请求返回异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getTouchApiCode().getMsg() + te.getExtendMsg());
        } catch (Exception e) {
            return TouchApiResponse.failed(e.getMessage());
        }
    }

    /**
     * 更新环节负责人
     * @param req
     * @return
     */
    @ApiOperation(value = "更新环节负责人")
    @RequestMapping(value = UPDATE_PROJECT_LINK_LEADER, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<TouchResponseModel> updateProjectLinkLeader(@RequestBody ProjectLinkReq req) throws Exception {
        try {
            projectLinkService.updateProjectLinkLeader(req);
            return TouchApiResponse.success("操作成功");
        } catch (TouchCodeException te) {
            log.error("请求返回异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getTouchApiCode().getMsg() + te.getExtendMsg());
        } catch (Exception e) {
            return TouchApiResponse.failed(e.getMessage());
        }
    }

    /**
     * 增加环节负责人
     * @param req
     * @return
     */
    @ApiOperation(value = "增加环节负责人")
    @RequestMapping(value = ADD_PROJECT_LINK_LEADER, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<TouchResponseModel> addProjectLinkLeader(@RequestBody ProjectLinkLeaderReq req) throws Exception {
        try {
            projectLinkService.addeProjectLinkLeader(req);
            return TouchApiResponse.success("操作成功");
        } catch (TouchCodeException te) {
            log.error("请求返回异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getTouchApiCode().getMsg() + te.getExtendMsg());
        } catch (Exception e) {
            return TouchApiResponse.failed(e.getMessage());
        }
    }

    /**
     * 删除环节
     * @param req
     * @return
     */
    @ApiOperation(value = "删除环节")
    @RequestMapping(value = DEL_LINK, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<TouchResponseModel> delLink(@RequestBody ProjectLinkReq req) throws Exception {
        try {
            projectLinkService.delete(req);
            return TouchApiResponse.success("操作成功");
        } catch (TouchCodeException te) {
            log.error("请求返回异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getTouchApiCode().getMsg() + te.getExtendMsg());
        } catch (Exception e) {
            return TouchApiResponse.failed(e.getMessage());
        }
    }
}
