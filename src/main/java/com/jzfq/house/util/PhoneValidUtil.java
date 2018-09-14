package com.jzfq.house.util;

import org.apache.commons.lang3.StringUtils;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class PhoneValidUtil {

    public static boolean isPhone(String phone){
        Pattern p=Pattern.compile("^1(3|4|5|7|8)\\d{9}$");
        Matcher m=p.matcher(phone);
        return m.matches();
    }

    public static boolean isPhone(String phone, boolean allowNull){
        if(StringUtils.isBlank(phone)){
            if(allowNull){
                return true;
            }else{
                return false;
            }
        }
        return isPhone(phone);
    }

//    public static void main(String[] args) {
//        System.out.println(isPhone("13015578619"));
//    }

}
