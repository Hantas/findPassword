package com.example.demo.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.javamail.JavaMailSenderImpl;
import org.springframework.mail.javamail.MimeMessageHelper;
import org.springframework.stereotype.Service;

import javax.mail.MessagingException;
import javax.mail.internet.MimeMessage;
import java.io.PrintWriter;

/**
 * Created by 10742 on 2018/1/2.
 */
@Service
public class SendMailService{

    @Autowired
    private JavaMailSenderImpl mailSender;

    public void sendHtmlMail(String from, String to, String content) throws MessagingException {

        MimeMessage mimeMessage = mailSender.createMimeMessage();
        MimeMessageHelper mimeMessageHelper = new MimeMessageHelper(mimeMessage);
        mimeMessageHelper.setTo(to);
        mimeMessageHelper.setFrom(from);
        mimeMessageHelper.setSubject("Spring Boot Mail 邮件测试【HTML】");
        // 启用html
        mimeMessageHelper.setText(content, true);
        // 发送邮件
        mailSender.send(mimeMessage);
        System.out.println("邮件已发送");
    }

}
