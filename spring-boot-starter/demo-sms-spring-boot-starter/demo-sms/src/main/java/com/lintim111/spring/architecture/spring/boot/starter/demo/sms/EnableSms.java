package com.lintim111.spring.architecture.spring.boot.starter.demo.sms;

import org.springframework.boot.autoconfigure.condition.ConditionalOnClass;
import org.springframework.context.annotation.Import;

import java.lang.annotation.*;

@Target({ElementType.TYPE})
@Retention(RetentionPolicy.RUNTIME)
@Documented
@Import({SmsAutoConfiguration.class})
//@ConditionalOnClass(com.lintim111.spring.architecture.spring.boot.starter.demo.sms.condition.EnableSmsCondition.class)
public @interface EnableSms {
}
