package com.lz;

import com.lz.event.LocalEvent;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = SpringBootApplication.class)
@RunWith(SpringRunner.class)
class SpringbootEventApplicationTests {

    @Autowired
    private ApplicationEventPublisher publisher;

    @Test
    void contextLoads() {
        publisher.publishEvent(new LocalEvent("","Hello World ..."));
    }

}
