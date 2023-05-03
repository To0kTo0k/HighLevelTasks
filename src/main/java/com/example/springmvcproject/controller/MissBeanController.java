package com.example.springmvcproject.controller;

import com.example.springmvcproject.entities.MissBean;
import org.springframework.beans.factory.annotation.Autowired;
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
public class MissBeanController {

    @Autowired
    private ApplicationContext context;
    private MissBean missBean;

    @PostMapping("/missbean")
    public ResponseEntity<MissBean> createMissBean() {
        this.missBean = context.getBean(MissBean.class);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/missbean")
    public ResponseEntity<MissBean> readMissBean(){
        return new ResponseEntity<>(this.missBean, HttpStatus.OK);
    }

    @PutMapping("/missbean")
    public ResponseEntity<MissBean> updateMissBean(@RequestBody MissBean speech) {
        String oldSpeech = this.missBean.getSpeech();
        this.missBean.setSpeech(speech.getSpeech());
        return (Objects.equals(oldSpeech, missBean.getSpeech()))
                ? new ResponseEntity<>(HttpStatus.NOT_MODIFIED)
                : new ResponseEntity<>(missBean, HttpStatus.OK);
    }

    @DeleteMapping("/missbean")
    public ResponseEntity<MissBean> deleteMissBean() {
        this.missBean = null;
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
