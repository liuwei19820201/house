package com.jzfq.house.swagger.model;

/**
 * 导入excel验证结果类
 *
 * @author Garen Gosling
 * @create 2018-04-22 17:26
 * @since v1.0
 */
public class ImportExcelResult {
    private Integer rowNo;      // excel行号
    private String res;     // 结果： 成功、失败
    private String message;     // 提示信息
    private Object data;        // 数据对象

    public ImportExcelResult() {
    }

    public ImportExcelResult(Integer rowNo, String res, String message, Object data) {
        this.rowNo = rowNo;
        this.res = res;
        this.message = message;
        this.data = data;
    }

    public Integer getRowNo() {
        return rowNo;
    }

    public void setRowNo(Integer rowNo) {
        this.rowNo = rowNo;
    }

    public String getRes() {
        return res;
    }

    public void setRes(String res) {
        this.res = res;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
