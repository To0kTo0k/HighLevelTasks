package com.example.springmvcproject.controller;

import com.example.springmvcproject.entities.MisterBean;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertNull;
import static org.junit.jupiter.api.Assertions.assertTrue;

@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
class MisterBeanControllerTest {
    @Test
    void createMisterBeanTest(@Autowired TestRestTemplate restTemplate) {
        assertTrue(restTemplate.postForEntity("/misterbean",
                null,
                MisterBean.class).getStatusCode().is2xxSuccessful());
    }

    @Test
    void readMisterBeanTest(@Autowired TestRestTemplate restTemplate) {
        restTemplate.postForEntity("/misterbean",
                null,
                MisterBean.class);
        ResponseEntity<MisterBean> response = restTemplate.getForEntity("/misterbean",
                MisterBean.class);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertNotNull(response.getBody());
    }

    @Test
    void putMisterBeanTest(@Autowired TestRestTemplate restTemplate) {
        restTemplate.postForEntity("/misterbean",
                null,
                MisterBean.class);
        MisterBean misterBean = new MisterBean();
        misterBean.setSpeech("Hohoho");
        HttpEntity<MisterBean> request = new HttpEntity<>(misterBean);
        ResponseEntity<MisterBean> response = restTemplate.exchange("/misterbean",
                HttpMethod.PUT,
                request,
                MisterBean.class);
        assertTrue(response.getStatusCode().is2xxSuccessful());
        assertNotNull(response.getBody());
    }

    @Test
    void deleteMisterBeanTest(@Autowired TestRestTemplate restTemplate) {
        restTemplate.postForEntity("/misterbean",
                null,
                MisterBean.class);
        ResponseEntity<Void> response = restTemplate.exchange("/misterbean",
                HttpMethod.DELETE,
                HttpEntity.EMPTY,
                Void.class);
        assertNull(response.getBody());
        assertTrue(response.getStatusCode().is2xxSuccessful());
    }
}