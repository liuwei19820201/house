package com.jzfq.house.service;

import java.util.List;

public class CommonMethods {

    public String failMsg(int count, String ids, List<String> failList){
        String failMsg = null;
        if(count != ids.split(",").length){
            failMsg = "操作失败项：";
            for(int i=0;i<failList.size();i++){
                failMsg += failList.get(i);
                if(i<failList.size() - 1){
                    failMsg += "，";
                }
                if(i == failList.size() - 1){
                    failMsg += "。";
                }
            }
        }
        return failMsg;
    }
}
