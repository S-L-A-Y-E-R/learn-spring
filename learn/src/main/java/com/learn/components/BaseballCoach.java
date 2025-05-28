package com.learn.components;

import com.learn.Coach;
import jakarta.annotation.PostConstruct;
import jakarta.annotation.PreDestroy;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Component;

@Component
//@Lazy
//@Scope(ConfigurableBeanFactory.SCOPE_PROTOTYPE)
public class BaseballCoach implements Coach {
//    public BaseballCoach() {
//        System.out.println("BaseballCoach");
//    }

    @Override
    public String getDailyWork() {
        return "Practice baseball  for 5 minutes";
    }

//    @PostConstruct
//    public void doSomething(){
//        System.out.println("Anything");
//    }

//    @PreDestroy
//    public void doSomething(){
//        System.out.println("Anything");
//    }
}
