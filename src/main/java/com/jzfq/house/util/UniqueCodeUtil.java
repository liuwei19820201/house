package com.jzfq.house.util;

import com.jzfq.house.util.date.DateUtil;

/**
 * 唯一编码工具类
 *
 * @author Garen Gosling
 * @create 2018-04-23 20:49
 * @since v1.0
 */
public class UniqueCodeUtil {

    /**
     * 长ID编码
     * @return
     */
    public static String idCode(){
        return hexTimeCode() + hexRandomCode(9);
    }

    /**
     * 短ID编码
     * @return
     */
    public static String idCodeShort(){
        String t = Long.toHexString(Long.parseLong(DateUtil.now("yyyyMMddHHmmssSSS").substring(2)));
        String r = Integer.toHexString(Integer.parseInt(RandomUtil.r9(1)));
        return hexTimeCodeShort() + hexRandomCode(1);
    }

    /**
     * 当前时间的16进制编码
     * @return
     */
    public static String hexTimeCode(){
        return Long.toHexString(Long.parseLong(DateUtil.now("yyyyMMddHHmmssSSS")));
    }

    /**
     * 当前时间的16进制编码（短）
     * @return
     */
    public static String hexTimeCodeShort(){
        return Long.toHexString(Long.parseLong(DateUtil.now("yyyyMMddHHmmssSSS").substring(2)));
    }

    /**
     * 最大9位随机数的16进制编码
     * @param len
     * @return
     */
    public static String hexRandomCode(int len){
        return Integer.toHexString(Integer.parseInt(RandomUtil.r9(len)));
    }
}
