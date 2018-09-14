package com.jzfq.house.runner;

import com.jzfq.house.service.SysAreaManage;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.stereotype.Component;

@Component
public class SysAreaRunner implements CommandLineRunner {

    @Autowired
    SysAreaManage sysAreaManage;

    @Override
    public void run(String... args) throws Exception {
        System.out.println("=========== redisSysAreaDTO beign ============");
        sysAreaManage.getTree();
        System.out.println("=========== redisSysAreaDTO end ============");
    }
}
