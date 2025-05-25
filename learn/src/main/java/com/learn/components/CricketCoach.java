package com.learn.components;

import com.learn.Coach;
import org.springframework.stereotype.Component;

@Component
public class CricketCoach implements Coach {
    @Override
    public String getDailyWork() {
        return "Practice fast bowling for 15 minutes";
    }
}
