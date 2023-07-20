package org.example;

import lombok.Getter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@Getter
@ToString
@Component
public class MisterBean {
    private String speech = "Hello";
}
