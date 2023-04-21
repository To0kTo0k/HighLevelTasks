package com.example.springmvcproject.entities;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Setter
@Getter
@ToString
@Component
public class MisterBean {
    private String speech = "Hello";
}
