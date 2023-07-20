package com.example.springmvcproject;

import com.example.springmvcproject.controller.MisterBeanController;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.assertj.core.api.Assertions.assertThat;

@SpringBootTest
class SpringMvcProjectApplicationTests {
    @Test
    void contextLoads(@Autowired MisterBeanController controller) {
        assertThat(controller).isNotNull();
    }
}
