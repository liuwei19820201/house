package com.jzfq.house.swagger.api.mp;

import com.jzfq.house.exception.TouchCodeException;
import com.jzfq.house.model.TouchResponseModel;
import com.jzfq.house.model.req.PageReq;
import com.jzfq.house.model.res.ListResultRes;
import com.jzfq.house.mybatis.domain.Project;
import com.jzfq.house.service.PersonService;
import com.jzfq.house.service.ProjectLinkService;
import com.jzfq.house.service.ProjectService;
import com.jzfq.house.swagger.model.BaseModel;
import com.jzfq.house.swagger.model.TouchApiResponse;
import com.jzfq.house.swagger.model.amp.ProjectReq;
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
@RequestMapping(value = "/mp")
public class MpController extends BaseModel {

    final String PROJECT_All = "project_all";

    private static final String PROJECT_LIST = "/projectList"; // 项目列表
    private static final String PROJECT_LIST_PAGE = "/projectListPage"; // 项目列表分页
    private static final String CREATE_PROJECT = "/createProject"; // 创建项目
    private static final String DEL_PROJECT = "/delProject"; // 删除项目

    @Autowired
    private ProjectService projectService;

    @Autowired
    private ProjectLinkService projectLinkService;

    @Autowired
    private PersonService personService;

    /**
     * 项目列表
     * @param req
     * @return
     */
    @ApiOperation(value = "项目列表")
    @RequestMapping(value = PROJECT_LIST, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    @Cacheable(value = PROJECT_All, key = PROJECT_All)
    public ResponseEntity<TouchResponseModel> projectList(@RequestBody ProjectReq req) {
        try {
            List<Map<String, Object>> list = projectService.findListAll(req);
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
     * 项目列表分页
     * @param req
     * @return
     */
    @ApiOperation(value = "项目列表分页")
    @RequestMapping(value = PROJECT_LIST_PAGE, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    @Cacheable(value = PROJECT_All, key = PROJECT_All)
    public ResponseEntity<TouchResponseModel> projectListPage(@ApiParam(value = "页码") @RequestParam(value = "page", required = false) Integer page,
                                                              @ApiParam(value = "每页数量") @RequestParam(value = "pageSize", required = false) Integer pageSize, @RequestBody ProjectReq req) {
        PageReq<ProjectReq> pageReq = new PageReq<>(page, pageSize, req);
        try {
            ListResultRes<Map<String, Object>> result = projectService.getList(pageReq.getPage(), pageReq.getPageSize(), req);
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
     * 创建项目
     * @param project
     * @return
     */
    @ApiOperation(value = "创建项目")
    @RequestMapping(value = CREATE_PROJECT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<TouchResponseModel> createProject(@RequestBody Project project) throws Exception {
        try {
            projectService.save(project);
            return TouchApiResponse.success("操作成功");
        } catch (TouchCodeException te) {
            log.error("请求返回异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getTouchApiCode().getMsg() + te.getExtendMsg());
        } catch (Exception e) {
            return TouchApiResponse.failed(e.getMessage());
        }
    }

    /**
     * 删除项目
     * @param project
     * @return
     */
    @ApiOperation(value = "删除项目")
    @RequestMapping(value = DEL_PROJECT, method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON)
    public ResponseEntity<TouchResponseModel> delProject(@RequestBody Project project) throws Exception {
        try {
            projectService.delete(project);
            return TouchApiResponse.success("操作成功");
        } catch (TouchCodeException te) {
            log.error("请求返回异常:{}", te.getMessage());
            return TouchApiResponse.failed(te.getTouchApiCode().getCode(), te.getTouchApiCode().getMsg() + te.getExtendMsg());
        } catch (Exception e) {
            return TouchApiResponse.failed(e.getMessage());
        }
    }

}
