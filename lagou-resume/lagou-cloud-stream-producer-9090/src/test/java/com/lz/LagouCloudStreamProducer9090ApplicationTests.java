package com.lz;

import com.lz.service.IMessageProducer;
import org.junit.jupiter.api.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest(classes = LagouCloudStreamProducer9090Application.class)
@RunWith(SpringRunner.class)
class LagouCloudStreamProducer9090ApplicationTests {

    @Autowired
    private IMessageProducer iMessageProducer;

    @Test
    void testSendMessage() {
        iMessageProducer.sendMessage("hello world");
    }

}
