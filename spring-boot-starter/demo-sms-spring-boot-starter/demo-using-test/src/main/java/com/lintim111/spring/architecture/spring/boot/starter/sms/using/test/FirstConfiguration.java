package com.lintim111.spring.architecture.spring.boot.starter.sms.using.test;

import com.lintim111.spring.architecture.spring.boot.starter.demo.sms.condition.EnableSmsCondition;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class FirstConfiguration {

    //@Bean
    public EnableSmsCondition enableSmsCondition(){
        return new EnableSmsCondition();
    }
}
