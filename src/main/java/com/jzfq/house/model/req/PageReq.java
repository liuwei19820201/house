package com.jzfq.house.model.req;

import com.jzfq.house.valid.CommonValid;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;

/**
 * @title: PageReq
 * @description:
 * @company: 北京桔子分期电子商务有限公司
 * @author: Liu Wei
 * @date: 2018/7/5 17:00
 */
@Getter
@Setter
@ToString
public class PageReq<T> implements Serializable {
    /**
     * 当前页
     */
    private Integer page=1;
    /**
     * 每页条数
     */
    private Integer pageSize=20;
    /**
     * 搜索条件
     */
    private T search;

    public PageReq(Integer page, Integer pageSize, T search) {
        CommonValid.stringParamsTrim(search);
        CommonValid.emptyStringToNull(search);
        this.search = search;
        if(page != null){
            this.page = page;
        }
        if(pageSize != null){
            this.pageSize = pageSize;
        }
    }

    public PageReq(){

    }
}
