package org.example;

import lombok.Data;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Data
@Component
public class MissBean {
    @Autowired
    private MisterBean misterBean;

    public void sayHi() {
        this.misterBean.setSpeech("Hi");
    }

    @Override
    public String toString() {
        return "MissBean(speech=" + this.misterBean.getSpeech() + ")";
    }
}
