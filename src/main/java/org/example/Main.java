package org.example;

import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.annotation.ImportResource;

@ImportResource("classpath:xmlBean.xml")
@SpringBootApplication
public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(Main.class);
        MisterBean misterBean = (MisterBean) context.getBean("misterBean");
        misterBean.setSpeech("Hello");
        System.out.println(misterBean);

        MisterBean xmlBean = (MisterBean) context.getBean("xmlbean");
        xmlBean.setSpeech("Hehe");
        System.out.println(xmlBean);

        MissBean missBean = context.getBean("Hi", MissBean.class);
        System.out.println(missBean);
    }
}