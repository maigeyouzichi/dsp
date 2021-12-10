package com.lz;

import com.lz.config.HelloConfig;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = LagouCloudNacosConfigApplication.class)
@RunWith(SpringRunner.class)
class LagouCloudNacosConfigApplicationTests {

    @Autowired
    private HelloConfig helloConfig;

    @Test
    void contextLoads() {
        System.out.println(helloConfig.getName());
        System.out.println(helloConfig.getRank());
    }



}
