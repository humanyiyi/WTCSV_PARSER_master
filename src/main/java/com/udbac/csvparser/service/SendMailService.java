package com.udbac.csvparser.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by root on 2016/10/25.
 */
@Service
public class SendMailService {

    @Autowired
    private JavaMailSender mailSender;

    public void sendFailedEmail() {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom("chaoslane@126.com");
            message.setTo("438908036@qq.com");
            message.setSubject("主题：CSV文件入库错误");
            message.setText("");
            mailSender.send(message);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }
}
