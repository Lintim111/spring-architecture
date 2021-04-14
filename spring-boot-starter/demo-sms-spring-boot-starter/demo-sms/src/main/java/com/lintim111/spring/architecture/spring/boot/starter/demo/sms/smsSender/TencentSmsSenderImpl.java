package com.lintim111.spring.architecture.spring.boot.starter.demo.sms.smsSender;

import com.lintim111.spring.architecture.spring.boot.starter.demo.sms.SmsProperties;
import com.lintim111.spring.architecture.spring.boot.starter.demo.sms.SmsSender;

public class TencentSmsSenderImpl implements SmsSender {
    private SmsProperties.SmsMessage smsMessage;

    public TencentSmsSenderImpl(SmsProperties.SmsMessage smsProperties) {
        this.smsMessage = smsProperties;
    }

    @Override
    public boolean send(String message) {
        System.out.println(smsMessage.toString()+"开始发送短信==》短信内容："+message);
        return true;
    }
}
