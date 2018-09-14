package com.jzfq.house.code;

import com.jzfq.house.serializable.SerializedObj;
import lombok.Data;

/**
 * 自增编码类
 *
 * @author Garen Gosling
 * @create 2018-04-28 03:23
 * @since v1.0
 */
@Data
public class Increment extends SerializedObj {
    private Integer id;                 // 数字编码
    private String code;                // 字符串编码
    private Integer size;               // 字符串编码位数
    private String label;               // 中文名称
    private String description;         // 描述
}
