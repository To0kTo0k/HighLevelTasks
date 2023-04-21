package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:xmlBean.xml")
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class);

        MisterBean misterBean = context.getBean("misterBean", MisterBean.class);
        misterBean.setSpeech("Hello");
        System.out.println(misterBean);

        MisterBean xmlBean = context.getBean("xmlbean", MisterBean.class);
        xmlBean.setSpeech("Hehe");
        System.out.println(xmlBean);

        MissBean missBean = context.getBean("missBean", MissBean.class);
        missBean.sayHi();
        System.out.println(missBean);
    }
}