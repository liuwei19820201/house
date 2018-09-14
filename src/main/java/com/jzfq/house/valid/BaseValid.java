package com.jzfq.house.valid;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class BaseValid {
    public boolean isInteger(String obj){
        Pattern patternInteger = Pattern.compile("^\\d?$");
        Matcher m = patternInteger.matcher(obj);
        if (m.matches()) {
            return true;
        } else {
            return false;
        }
    }

}
