package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        MisterBean helloBean = (MisterBean) context.getBean("Hello");
        System.out.println(helloBean.getSpeech());
        MisterBean hiBean = (MisterBean) context.getBean("Hi");
        System.out.println(hiBean.getSpeech());
        MisterBean byeBean = (MisterBean) context.getBean("Bye");
        System.out.println(byeBean.getSpeech());
    }
}