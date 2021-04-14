package com.lintim111.spring.architecture.spring.boot.starter.sms.using.test;

import com.lintim111.spring.architecture.spring.boot.starter.demo.sms.EnableSms;
import com.lintim111.spring.architecture.spring.boot.starter.demo.sms.condition.EnableSmsCondition;
import com.lintim111.spring.architecture.spring.boot.starter.demo.sms.smsSender.AliyunSmsSenderImpl;
import com.lintim111.spring.architecture.spring.boot.starter.demo.sms.smsSender.TencentSmsSenderImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ConfigurableApplicationContext;

@SpringBootApplication
@EnableSms// 优先读取 spring.factories 中配置的 EnableAutoConfiguration
public class AutoConfigApplication {
    public static void main(String[] args) {
        ConfigurableApplicationContext applicationContext = SpringApplication.run(AutoConfigApplication.class, args);
        //EnableSmsCondition condition = applicationContext.getBean(EnableSmsCondition.class);
        //System.out.println(condition);
        AliyunSmsSenderImpl aliyunSmsSender = applicationContext.getBean(AliyunSmsSenderImpl.class);
        aliyunSmsSender.send("用阿里云发送短信");
        TencentSmsSenderImpl tencentSmsSender = applicationContext.getBean(TencentSmsSenderImpl.class);
        tencentSmsSender.send("用腾讯云发送短信");
    }
}
