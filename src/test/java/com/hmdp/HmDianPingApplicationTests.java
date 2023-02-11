package com.hmdp;

import cn.hutool.core.util.RandomUtil;
import com.hmdp.entity.Mail;
import com.hmdp.utils.MailUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

@SpringBootTest
@RunWith(SpringRunner.class)
public class HmDianPingApplicationTests {

    @Autowired
    private MailUtil mailUtil;

    @Test
    public void mailSend(){
        String code = RandomUtil.randomNumbers(4);
        Mail mail = new Mail();
        mail.setContent("您的验证码是：" + code + "，三分钟有效，如果不是本人操作，请无视本条信息。");
        mail.setRecipient("1287288662@qq.com");
        mail.setSubject("注册验证码");

        mailUtil.sendSimpleMail(mail);
    }

}
