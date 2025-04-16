package org.example.web.config;

import org.example.web.sentinel.MyBlockExceptionHandler;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import javax.annotation.PostConstruct;

@Configuration
public class Config {
    @Bean
    public MyBlockExceptionHandler myBlockExceptionHandler() {
        return new MyBlockExceptionHandler();
    }

    @PostConstruct
    public void init() {
        //DubboFallbackRegistry.setConsumerFallback();
    }

}
