package com.example.springmvcproject;

import com.example.springmvcproject.entities.MissBean;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:xmlBean.xml")
@ComponentScan
@Configuration
public class ConfigBean {
    @Bean
    public MissBean missBean() {
        return new MissBean("Hi");
    }
}
