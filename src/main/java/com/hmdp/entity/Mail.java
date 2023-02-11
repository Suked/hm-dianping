package com.hmdp.entity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.io.Serializable;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Mail implements Serializable {
    private static final long serialVersionUID = -2116367492649751914L;

    private String recipient;//邮件接收人
    private String subject; //邮件主题
    private String content; //邮件内容


}
