package com.jzfq.house.util;

import org.apache.commons.beanutils.PropertyUtils;

import java.lang.reflect.InvocationTargetException;

/**
 * 类型转换工具类
 *
 * @author Garen Gosling
 * @create 2017-09-14 22:43
 * @since v1.0
 */
public class TransferUtil {

    /**
     * 类型转换（处理异常）
     *
     * @param dist
     * @param obj
     */
    public static void transfer(Object dist, Object obj) {
        try {
            PropertyUtils.copyProperties(dist, obj);
        } catch (IllegalAccessException e) {
            e.printStackTrace();
        } catch (InvocationTargetException e) {
            e.printStackTrace();
        } catch (NoSuchMethodException e) {
            e.printStackTrace();
        }
    }

    /**
     * 类型转换（不处理异常）
     *
     * @param dest
     * @param orig
     * @throws IllegalAccessException
     * @throws NoSuchMethodException
     * @throws InvocationTargetException
     */
    public static void transferThrow(Object dest, Object orig) throws IllegalAccessException, NoSuchMethodException, InvocationTargetException {
        PropertyUtils.copyProperties(dest, orig);
    }

}
