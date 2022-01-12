package com.lz;

import com.lz.service.TestService;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = SpringbootAopApplication.class)
@RunWith(SpringRunner.class)
class SpringbootAopApplicationTests {

    @Autowired
    private TestService testService;

    @Test
    public void testAop(){

        String result = testService.test02(1);
        System.out.println(result);
    }

}
