package com.example.springmvcproject.controller;

import com.example.springmvcproject.entities.MisterBean;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;

import java.util.Objects;

@Controller
public class MisterBeanController {
    private final ApplicationContext context;

    MisterBean misterBean;

    public MisterBeanController(ApplicationContext context) {
        this.context = context;
    }

    @PostMapping("/misterbean")
    public ResponseEntity<MisterBean> createMisterBean() {
        this.misterBean = context.getBean(MisterBean.class);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/misterbean")
    public ResponseEntity<MisterBean> readMisterBean() {
        return new ResponseEntity<>(this.misterBean, HttpStatus.OK);
    }

    @PutMapping("/misterbean")
    public ResponseEntity<MisterBean> updateMisterBean(@RequestBody MisterBean speech) {
        String oldSpeech = this.misterBean.getSpeech();
        this.misterBean.setSpeech(speech.getSpeech());
        return (Objects.equals(oldSpeech, this.misterBean.getSpeech()))
                ? new ResponseEntity<>(HttpStatus.NOT_MODIFIED)
                : new ResponseEntity<>(this.misterBean, HttpStatus.OK);
    }

    @DeleteMapping("/misterbean")
    public ResponseEntity<MisterBean> deleteMisterBean() {
        this.misterBean = null;
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
