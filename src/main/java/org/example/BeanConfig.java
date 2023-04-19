package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class BeanConfig {
    @Bean("Hello")
    public MisterBean sayHello() {
        return new MisterBean("Hello");
    }

    @Bean("Hi")
    public MisterBean sayHi() {
        return new MisterBean("Hi");
    }

    @Bean("Bye")
    public MisterBean sayBye() {
        return new MisterBean("Bye");
    }
}
