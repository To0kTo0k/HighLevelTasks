package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        MisterBean misterBean = (MisterBean) context.getBean("misterBean");
        misterBean.setSpeech("Hello");
        System.out.println(misterBean);
        MissBean missBean = context.getBean(MissBean.class, "Hi");
        System.out.println(missBean);
        MisterBean xmlBean = (MisterBean) context.getBean("xmlbean");
        xmlBean.setSpeech("Hehe");
        System.out.println(xmlBean);
    }
}