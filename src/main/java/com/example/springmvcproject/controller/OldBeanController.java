package com.example.springmvcproject.controller;

import com.example.springmvcproject.entities.OldBean;
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
public class OldBeanController {
    @Autowired
    private ApplicationContext context;
    private OldBean oldBean;

    @PostMapping("/oldbean")
    public ResponseEntity<OldBean> createOldBean() {
        oldBean = context.getBean(OldBean.class);
        return  new ResponseEntity<>(HttpStatus.OK);
    }

    @GetMapping("/oldbean")
    public ResponseEntity<OldBean> readOldBean(){
        return new ResponseEntity<>(oldBean, HttpStatus.OK);
    }

    @PutMapping("/oldbean")
    public ResponseEntity<OldBean> updateOldBean(@RequestBody OldBean speech) {
        String oldSpeech = oldBean.getSpeech();
        oldBean.setSpeech(speech.getSpeech());
        return (Objects.equals(oldSpeech, oldBean.getSpeech()))
                ? new ResponseEntity<>(HttpStatus.NOT_MODIFIED)
                : new ResponseEntity<>(oldBean, HttpStatus.OK);
    }

    @DeleteMapping("/oldbean")
    public ResponseEntity<OldBean> deleteOldBean() {
        oldBean = null;
        return new ResponseEntity<>(HttpStatus.OK);
    }
}
