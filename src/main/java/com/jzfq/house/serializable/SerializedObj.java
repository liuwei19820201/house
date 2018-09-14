package com.jzfq.house.serializable;

import lombok.Data;

import java.io.Serializable;

/**
 * 序列化父类
 *
 * @author Garen Gosling
 * @create 2018-04-28 00:55
 * @since v1.0
 */
@Data
public class SerializedObj implements Serializable {
    private String name;

}
