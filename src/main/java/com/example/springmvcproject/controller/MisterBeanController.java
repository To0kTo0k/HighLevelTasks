package com.example.springmvcproject.controller;

import com.example.springmvcproject.entities.MisterBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationContext;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Objects;

@RestController
public class MisterBeanController {

    @Autowired
    private ApplicationContext context;
    MisterBean misterBean;

    @PostMapping("/misterbean")
    public ResponseEntity<MisterBean> createMisterBean() {
        misterBean = context.getBean(MisterBean.class);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/misterbean")
    public ResponseEntity<MisterBean> readMisterBean() {
        return new ResponseEntity<>(misterBean, HttpStatus.OK);
    }

    @PutMapping("/misterbean")
    public ResponseEntity<MisterBean> updateMisterBean(@RequestBody MisterBean speech) {
        String oldSpeech = misterBean.getSpeech();
        misterBean.setSpeech(speech.getSpeech());
        return (Objects.equals(oldSpeech, misterBean.getSpeech())) ? new ResponseEntity<>(HttpStatus.NOT_MODIFIED) : new ResponseEntity<>(misterBean, HttpStatus.OK);
    }

    @DeleteMapping("/misterbean")
    public ResponseEntity<MisterBean> deleteMisterBean() {
        misterBean = null;
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
