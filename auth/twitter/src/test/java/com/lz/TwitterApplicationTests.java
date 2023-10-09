package com.lz;

import com.lz.service.TwitterService;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class TwitterApplicationTests {

    @Autowired
    private TwitterService twitterService;

    @Test
    void contextLoads() {

        twitterService.verifyCredentials();

    }

}
