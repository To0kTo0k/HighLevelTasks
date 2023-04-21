package com.example.springmvcproject;

import com.example.springmvcproject.entities.MissBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:xmlBean.xml")
@Configuration
public class ConfigBean {
    @Bean
    public MissBean hiBean() {
        return new MissBean("Hi");
    }

    @Bean
    public MissBean byeBean() {
        return new MissBean("Bye");
    }
}
