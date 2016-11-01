package com.udbac.csvparser.service;

import com.udbac.csvparser.utils.ParserProperties;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.mail.MailProperties;
import org.springframework.mail.MailException;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Service;

/**
 * Created by root on 2016/10/25.
 * 邮件告警 由于生产环境没有外网 暂未启用
 */
@Service
public class SendMailService {

    @Autowired
    private JavaMailSender mailSender;
    @Autowired
    private MailProperties mailProperties;
    @Autowired
    private ParserProperties parserProperties;

    public void sendFailedEmail() {
        try {
            SimpleMailMessage message = new SimpleMailMessage();
            message.setFrom(mailProperties.getUsername());
            message.setTo(parserProperties.getAddressees().split(","));
            message.setSubject("主题：广告进站行为分析报告入库失败");
            message.setText("CSV文件入库异常 请查看日志 日志路径配置在 logback/base.xml中");
            mailSender.send(message);
        } catch (MailException e) {
            e.printStackTrace();
        }
    }
}
