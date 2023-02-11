package com.hmdp.utils;

import com.hmdp.entity.Mail;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.mail.SimpleMailMessage;
import org.springframework.mail.javamail.JavaMailSender;
import org.springframework.stereotype.Component;

@Slf4j
@Component
public class MailUtil {

    @Value("${spring.mail.username}")
    private String MAIL_SENDER; // 邮件发送者

    @Autowired
    private JavaMailSender javaMailSender;//注入QQ发送邮件的bean

    public void sendSimpleMail(Mail mailBean) {
        try {
            SimpleMailMessage mailMessage= new SimpleMailMessage();
            mailMessage.setFrom(MAIL_SENDER);//发送者
            mailMessage.setTo(mailBean.getRecipient());//接收者
            mailMessage.setSubject(mailBean.getSubject());//邮件标题
            mailMessage.setText(mailBean.getContent());//邮件内容
            javaMailSender.send(mailMessage);//发送邮箱
        } catch (Exception e) {
            throw new RuntimeException("邮件发送错误！" + e.getMessage());
        }
    }

}
