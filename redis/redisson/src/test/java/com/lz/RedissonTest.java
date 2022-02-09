package com.lz;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.redisson.api.RedissonClient;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = RedissonApplication.class)
@RunWith(SpringRunner.class)
public class RedissonTest {

    @Autowired
    RedissonClient redissonClient;

    @Test
    public void TestRedisson() {
        System.out.println(redissonClient);
    }
}
