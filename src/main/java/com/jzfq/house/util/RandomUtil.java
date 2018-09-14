package com.jzfq.house.util;

import java.util.Random;

/**
 * 随机数工具类
 *
 * @author Garen Gosling
 * @create 2018-04-21 16:58
 * @since v1.0
 */
public class RandomUtil {

    /**
     * 生成len位0~9的随机数，如果len>9则生成9位数字，如果len<1则生成固定数字0
     * @param len 位数
     * @return
     */
    public static String r9(int len){
        if(len < 1){
            return "0";
        }
        if(len > 9){
            len = 9;
        }
        StringBuilder sb = new StringBuilder();
        for(int i=0;i<len;i++){
            sb.append(new Random().nextInt(10));
        }
        return sb.toString();
    }


//    public static void main(String[] args) {
//        for(int i=0;i<1000;i++){
//            System.out.println(r9(3));
//        }
//    }

}
