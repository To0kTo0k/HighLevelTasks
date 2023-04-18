package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

class MisterBeanTest {
    @Test
    void annotationBeanConfigTest() {
        ApplicationContext context = new AnnotationConfigApplicationContext(BeanConfig.class);
        assertEquals("Hello", context.getBean(MisterBean.class).getSpeech());
    }

    @Test
    void xmlBeanConfigTest() {
        ApplicationContext context = new ClassPathXmlApplicationContext("xmlBeanConfig.xml");
        assertEquals("Hi", context.getBean(MisterBean.class).getSpeech());
    }
}
