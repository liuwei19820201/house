package com.jzfq.house.valid;

import lombok.extern.slf4j.Slf4j;
import org.apache.commons.lang3.StringUtils;

import java.lang.reflect.Field;

@Slf4j
public class CommonValid {
    public static void emptyStringToNull(Object obj){
        Class cls = obj.getClass();
        Field[] fields = cls.getDeclaredFields();
        for (int i=0;i<fields.length;i++){
            try {
                Field field = fields[i];
                field.setAccessible(true);
                String name = field.getName();
                Object value = field.get(obj);
                if(value instanceof String && StringUtils.isBlank((String)value)){
                    field.set(obj, null);
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }
    public static void stringParamsTrim(Object obj){
        Class cls = obj.getClass();
        log.info("class: {}, 入参：{}", cls.getSimpleName(), obj.toString());
        Field[] fields = cls.getDeclaredFields();
        for (int i=0;i<fields.length;i++){
            try {
                Field field = fields[i];
                field.setAccessible(true);
                String name = field.getName();
                Object value = field.get(obj);
                if(value instanceof String && value != null){
                    field.set(obj, ((String) value).trim());
                }
            } catch (IllegalAccessException e) {
                e.printStackTrace();
            }
        }
    }

    public static String stringTrim(String str){
        log.info("入参：{}", str);
        if(str != null){
            return str.trim();
        }
        return null;
    }
}
