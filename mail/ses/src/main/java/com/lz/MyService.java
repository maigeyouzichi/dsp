package com.lz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MyService {

    private final EmailService emailService;

    @Autowired
    public MyService(EmailService emailService) {
        this.emailService = emailService;
    }

    public void sendNotification() {
        String to = "maigeyouzichi@gmail.com";
        String subject = "Notification";
        String body = "hello, deer pomelo";
        emailService.sendEmail(to, subject, body);
    }
}
