package com.learn.components;

import com.learn.Coach;

public class SwimCoach implements Coach {

    @Override
    public String getDailyWork() {
        return "Swim for 10 minutes";
    }
}
