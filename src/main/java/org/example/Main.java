package org.example;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = SpringApplication.run(Main.class);

        MisterBean misterBean = context.getBean("misterBean", MisterBean.class);
        System.out.println(misterBean);

        OldBean xmlBean = context.getBean("xmlBean", OldBean.class);
        System.out.println(xmlBean);

        MissBean hiBean = context.getBean("hiBean", MissBean.class);
        System.out.println(hiBean);

        MissBean byeBean = context.getBean("byeBean", MissBean.class);
        System.out.println(byeBean);
    }
}