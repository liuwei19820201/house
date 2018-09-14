package com.jzfq.house.swagger.model;

import com.jzfq.house.enums.TouchApiCode;
import com.jzfq.house.model.TouchResponseModel;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

/**
 * @Company: 北京桔子分期电子商务有限公司
 * @Author Li Zhe lizhe@juzifenqi.com
 * @Date 2018年06月29日 18:25
 * @Description: 返回接口格式
 */
public class TouchApiResponse {

    private static final String EMPTY = "";

    public static ResponseEntity<TouchResponseModel> success(Object data) {
        return success(data, EMPTY);
    }

    public static ResponseEntity<TouchResponseModel> success(String msg) {
        return success(EMPTY, msg);
    }

    public static ResponseEntity<TouchResponseModel> success(Object data, String msg) {
        TouchResponseModel successModel = successModel(data, msg);
        return new ResponseEntity<TouchResponseModel>(successModel, HttpStatus.OK);
    }

    public static ResponseEntity<TouchResponseModel> badRequest(String msg) {
        TouchResponseModel badRequestModel = badRequestModel(msg);
        return new ResponseEntity<TouchResponseModel>(badRequestModel, HttpStatus.OK);
    }

    public static ResponseEntity<TouchResponseModel> failed(String msg) {
        TouchResponseModel em = new TouchResponseModel();
        em.setData(null);
        em.setMsg(msg);
        em.setErrorCode(TouchApiCode.TOUCH_API_CODE_9999.getCode());
        em.setResult("0");
        return new ResponseEntity<TouchResponseModel>(em, HttpStatus.OK);
    }

    public static ResponseEntity<TouchResponseModel> failed(String code, String msg) {
        TouchResponseModel em = new TouchResponseModel();
        em.setData(null);
        em.setMsg(msg);
        em.setErrorCode(code);
        em.setResult("0");
        return new ResponseEntity<TouchResponseModel>(em, HttpStatus.OK);
    }

    private static TouchResponseModel successModel(final Object data) {
        return successModel(data, EMPTY);
    }

    private static TouchResponseModel successModel(final Object data, final String msg) {
        return successModelBase(data, msg);
    }

    private static TouchResponseModel successModelBase(final Object data, final String msg) {
        TouchResponseModel sm = new TouchResponseModel();
        sm.setData(data);
        sm.setMsg(msg);
        sm.setResult("1");
        return sm;
    }

    private static TouchResponseModel errorModel(final String msg) {
        TouchResponseModel em = new TouchResponseModel();
        em.setErrorCode(HttpStatus.INTERNAL_SERVER_ERROR.value() + "");
        em.setMsg(msg);
        return em;
    }

    private static TouchResponseModel badRequestModel(String msg) {
        TouchResponseModel bm = new TouchResponseModel();
        bm.setData(null);
        bm.setErrorCode(TouchApiCode.TOUCH_API_CODE_9999.getCode());
        bm.setMsg(msg);
        bm.setResult("0");
        return bm;
    }

}
