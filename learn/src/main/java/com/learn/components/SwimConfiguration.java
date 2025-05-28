package com.learn.components;

import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

@Configuration
public class SwimConfiguration {
    @Bean("swim")
    public SwimCoach createSwimCoach(){
        return new SwimCoach();
    }
}
