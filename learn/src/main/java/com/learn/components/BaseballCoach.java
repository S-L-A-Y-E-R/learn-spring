package com.learn.components;

import com.learn.Coach;
import org.springframework.context.annotation.Lazy;
import org.springframework.stereotype.Component;

@Component
//@Lazy
public class BaseballCoach implements Coach {
    public BaseballCoach() {
        System.out.println("BaseballCoach");
    }

    @Override
    public String getDailyWork() {
        return "Practice baseball  for 5 minutes";
    }
}
