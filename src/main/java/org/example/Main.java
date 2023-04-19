package org.example;

import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

public class Main {
    public static void main(String[] args) {
        ApplicationContext annotationContext = new AnnotationConfigApplicationContext(BeanConfig.class);
        MisterBean annotationBean = annotationContext.getBean(MisterBean.class);
        System.out.println(annotationBean.getSpeech());

        ApplicationContext xmlContext = new ClassPathXmlApplicationContext("xmlBeanConfig.xml");
        MisterBean xmlBean = xmlContext.getBean(MisterBean.class);
        System.out.println(xmlBean.getSpeech());
    }
}