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
        String to = "recipient@example.com";
        String subject = "Notification";
        String body = "This is a notification email.";
        emailService.sendEmail(to, subject, body);
    }
}
