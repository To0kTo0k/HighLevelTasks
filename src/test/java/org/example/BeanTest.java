package org.example;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.context.ApplicationContext;

import static org.junit.jupiter.api.Assertions.assertEquals;

@SpringBootTest
class BeanTest {
    @Autowired
    private ApplicationContext context;

    @Test
    void misterBeanTest() {
        MisterBean misterBean = context.getBean("misterBean", MisterBean.class);
        assertEquals("Hello", misterBean.getSpeech());
    }

    @Test
    void missBeanTest() {
        MissBean missBean = context.getBean("hiBean", MissBean.class);
        assertEquals("Hi", missBean.getSpeech());
        missBean = context.getBean("byeBean", MissBean.class);
        assertEquals("Bye", missBean.getSpeech());
    }

    @Test
    void oldBeanTest() {
        OldBean oldBean = context.getBean("xmlBean", OldBean.class);
        assertEquals("Hehe", oldBean.getSpeech());
    }

}
