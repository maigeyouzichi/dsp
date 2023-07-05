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
        emailService.sendEmail(
            "maigeyouzichi@gmail.com",
            "Log in to dFans.xyz",
            "Welcome to dfans.xyz\nVerification code is:"+ "123456" + "\nThis code expires in 20 minutes."
        );
    }
}
