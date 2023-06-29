package com.lz;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/email")
public class EmailController {
    private final EmailService emailService;

    @Autowired
    public EmailController(EmailService emailService) {
        this.emailService = emailService;
    }

    @GetMapping("/send")
    public String sendEmail() {
        String recipientEmail = "maigeyouzichi@gmail.com";
        String subject = "Test Email";
        String body = "This is a test email from Spring Boot.";

        emailService.sendEmail(recipientEmail, subject, body);

        return "Email sent!";
    }
}
