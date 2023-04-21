package org.example;

import lombok.Data;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
public class MissBean {
    private String speech;

    @Bean(name = "Hi")
    public void sayHi() {
        this.speech = "Hi";
    }

    @Bean(name = "Bye")
    public void sayBye() {
        this.speech = "Bye";
    }
}
