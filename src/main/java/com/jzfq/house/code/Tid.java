package com.jzfq.house.code;

import com.jzfq.house.util.UniqueCodeUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class Tid {
    @Autowired
    IncrementHandler incrementHandler;


    public String getTOrgId(){
        return "O-" + UniqueCodeUtil.idCodeShort();
    }

    public String getTPostId(){
        return "P-" + UniqueCodeUtil.idCodeShort();
    }

    public String getTHrId(){
        return "H-" + UniqueCodeUtil.idCodeShort();
    }

    public String getEmpNo(String path){
        Increment increment = incrementHandler.get("EMP_NO", path);
        if(increment == null){
            increment = initEmpIncrement();
        }
        return "GH-" + increment.getCode();
    }

    public void consumeEmpNo(String path){
        incrementHandler.consume("EMP_NO", path);
    }

    private Increment initEmpIncrement(){
        Increment increment = new Increment();
        increment.setId(1);
        increment.setCode("000001");
        increment.setSize(7);
        increment.setName("EMP_NO");
        increment.setLabel("工号");
        increment.setDescription("员工工号，递增");
        return increment;
    }
}
