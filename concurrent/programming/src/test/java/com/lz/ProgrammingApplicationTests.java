package com.lz;

import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class ProgrammingApplicationTests {

    @Test
    void contextLoads() {
        System.out.println("hello world");
        new Thread().start();
    }

}
