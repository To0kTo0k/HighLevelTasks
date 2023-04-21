package org.example;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:xmlBean.xml")
@Configuration
public class ConfigBean {
    @Bean
    public MisterBean hiBean() {
        MisterBean misterBean = new MisterBean();
        misterBean.setSpeech("Hi");
        return misterBean;
    }

    @Bean
    public MisterBean byeBean() {
        MisterBean misterBean = new MisterBean();
        misterBean.setSpeech("Bye");
        return misterBean;
    }
}
