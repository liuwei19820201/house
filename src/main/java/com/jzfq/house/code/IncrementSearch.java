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
public class IncrementSearch extends SerializedObj {
    private Integer start;
    private Integer length;
    private String name;                // 编码名称
    private String label;               // 中文名称
}
