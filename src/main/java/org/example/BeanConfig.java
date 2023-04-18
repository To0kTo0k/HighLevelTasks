package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean
    public MisterBean sayHello() {
        return new MisterBean("Hello");
    }
}
