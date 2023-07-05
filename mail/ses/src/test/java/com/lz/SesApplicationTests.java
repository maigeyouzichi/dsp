package com.lz;

import com.lz.service.EmailService2;
import lombok.SneakyThrows;
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

    @Autowired
    private EmailService2 emailService2;

    @Test
    void contextLoads() {
        myService.sendNotification();
    }

    @SneakyThrows
    @Test
    void sendTemplateEmail() {
        emailService2.sendTemplateEmail("dfansdeveloper@gmail.com","maigeyouzichi@gmail.com","Log in to dFans.xyz");
    }

}
