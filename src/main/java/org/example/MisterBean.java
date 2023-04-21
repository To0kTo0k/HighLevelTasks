package org.example;

import lombok.AllArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.springframework.stereotype.Component;

@AllArgsConstructor
@Setter
@ToString
@Component
public class MisterBean {
    private String speech;

    public MisterBean() {
        this.speech = "Hello";
    }
}
