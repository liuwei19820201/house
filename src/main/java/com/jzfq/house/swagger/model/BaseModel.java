package com.jzfq.house.swagger.model;

import com.jzfq.house.jpa.entity.Project;
import org.apache.poi.ss.formula.functions.T;
import org.springframework.data.domain.Page;
import org.springframework.http.HttpStatus;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 模板业务类
 *
 * @author Garen Gosling
 * @create 2017-09-16 04:30
 * @since v1.0
 */
public class BaseModel {

    /**
     * 成功模板
     *
     * @param operation
     * @param data
     * @return
     */
    public ResponseModel successModel(String operation, Object data){
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(HttpStatus.OK.value());
        responseModel.setMessage(operation + "成功");
        responseModel.setData(data);
        return responseModel;
    }

    public ResponseModel successModel(Object data){
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(HttpStatus.OK.value());
        responseModel.setMessage("操作成功");
        responseModel.setData(data);
        return responseModel;
    }

    /**
     * 成功模板
     *
     * @param operation
     * @return
     */
    public ResponseModel successModel(String operation){
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(HttpStatus.OK.value());
        responseModel.setMessage(operation + "成功");
        return responseModel;
    }

    /**
     * 成功模板
     *
     * @param msg
     * @return
     */
    public ResponseModel successModelMsg(String msg){
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(HttpStatus.OK.value());
        responseModel.setMessage(msg);
        return responseModel;
    }

    /**
     * 成功模板
     *
     * @return
     */
    public ResponseModel successModel(){
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(HttpStatus.OK.value());
        responseModel.setMessage("操作成功");
        return responseModel;
    }

    /**
     * 未通过验证模板
     *
     * @return
     */
    public ResponseModel badRequestModel(String msg){
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(HttpStatus.BAD_REQUEST.value());
        responseModel.setMessage(msg);
        return responseModel;
    }
    public ResponseModel badRequestModel(){
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(HttpStatus.BAD_REQUEST.value());
        responseModel.setMessage("操作失败");
        return responseModel;
    }

    /**
     * 异常模板
     *
     * @param msg
     * @param exception
     * @return
     */
    public ResponseModel exceptionModel(String msg, String exception){
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseModel.setMessage(msg);
        responseModel.setData(exception);
        return responseModel;
    }

    /**
     * 异常模板
     *
     * @param msg
     * @return
     */
    public ResponseModel exceptionModel(String msg){
        ResponseModel responseModel = new ResponseModel();
        responseModel.setCode(HttpStatus.INTERNAL_SERVER_ERROR.value());
        responseModel.setMessage(msg);
        return responseModel;
    }

    public Map page(Object list , long count){
        Map map 			            = new HashMap();
        map.put("recordsTotal", 		count);
        map.put("data",                 list);
        return map;
    }

    public Map page(Object list){
        Page<T> page = (Page<T>)list;
        Map map 			            = new HashMap();
        map.put("recordsTotal", 		page.getTotalElements());
        map.put("data",                 page.getContent());
        return map;
    }
}
