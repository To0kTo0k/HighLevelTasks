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

        MisterBean xmlBean = context.getBean("xmlBean", MisterBean.class);
        System.out.println(xmlBean);

        MisterBean hiBean = context.getBean("hiBean", MisterBean.class);
        System.out.println(hiBean);

        MisterBean byeBean = context.getBean("byeBean", MisterBean.class);
        System.out.println(byeBean);
    }
}