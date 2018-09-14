package com.jzfq.house.model.res;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

import java.io.Serializable;
import java.util.List;

/**
 * @Author lizhe lizhe@juzifenqi.com
 * @Date 2018年06月25日 20:34
 * @Description: 分页工具封装返回
 */
@ToString
@Getter
@Setter
public class ListResultRes<T> implements Serializable{
    /**
     * 列数据
     */
    private List<T> list;
    /**
     * 查询总行数
     */
    private Long total;
    /**
     * 当前页
     */
    private Integer page;
    /**
     * 每页多少条
     */
    private Integer pageSize;


    public ListResultRes() {
    }

    public ListResultRes(List<T> list, Long total, Integer page, Integer pageSize) {
        this.list = list;
        this.total = total;
        this.pageSize = pageSize;
        this.page = page;
    }

    public static ListResultRes newListResult(List list, Long total) {
        return new ListResultRes(list, total, null, null);
    }

    public static ListResultRes newListResult(List list, Long total, Integer page, Integer pageSize) {
        return new ListResultRes(list, total, page, pageSize);
    }
}
