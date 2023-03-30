package com.hmdp;

import cn.hutool.core.util.RandomUtil;
import com.auth0.jwt.interfaces.DecodedJWT;
import com.hmdp.entity.Mail;
import com.hmdp.entity.User;
import com.hmdp.utils.MailUtil;
import com.hmdp.utils.TokenUtil;
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

    @Test
    public void tokenTest(){
        User user = new User();
        user.setId(1l);
        user.setPassword("123456");
        String token = TokenUtil.getToken(user);
        System.out.println(token);

        DecodedJWT jwt = TokenUtil.checkToken(user, token);
        System.out.println(jwt.getHeader() + "==" +jwt.getPayload().toString() + "==" + jwt.getSignature());

    }

}
