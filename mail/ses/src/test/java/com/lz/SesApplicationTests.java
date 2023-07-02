package com.lz;

import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = SesApplication.class)
@RunWith(SpringRunner.class)
class SesApplicationTests {

    @Autowired
    private MyService myService;

    @Test
    void contextLoads() {
        myService.sendNotification();
    }

}
