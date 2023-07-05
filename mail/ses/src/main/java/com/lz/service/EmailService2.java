package com.lz.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;
import org.thymeleaf.TemplateEngine;
import org.thymeleaf.context.Context;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;

@Service
public class EmailService2 {

    private final JavaMailSender mailSender;
    private final TemplateEngine templateEngine;

    @Autowired
    public EmailService2(JavaMailSender mailSender, TemplateEngine templateEngine) {
        this.mailSender = mailSender;
        this.templateEngine = templateEngine;
    }

    public void sendTemplateEmail(String from ,String toEmail, String subject) throws MessagingException {
        MimeMessage message = mailSender.createMimeMessage();
        MimeMessageHelper helper = new MimeMessageHelper(message, true);

        helper.setTo(toEmail);
        helper.setFrom(from);
        helper.setSubject(subject);

        Context context = new Context();
        // 添加模板中需要的变量
        context.setVariable("name", "pomelo");

        String emailContent = templateEngine.process("hello", context);
        helper.setText(emailContent, true);

        // 添加附件示例
        //ClassPathResource attachment = new ClassPathResource("attachment.pdf");
        //helper.addAttachment(attachment.getFilename(), attachment);

        mailSender.send(message);
    }
}
