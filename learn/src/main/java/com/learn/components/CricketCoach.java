package com.learn.components;

import com.learn.Coach;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Component;

@Component
@Primary
public class CricketCoach implements Coach {
    public CricketCoach() {
        System.out.println("CricketCoach");
    }

    @Override
    public String getDailyWork() {
        return "Practice fast bowling for 15 minutes";
    }
}
