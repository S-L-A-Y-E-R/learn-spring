package com.learn.rest;

import com.learn.Coach;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class DemoController {
//Field Injection
//@Qualifier("baseballCoach")
//@Autowired
    private final Coach coach;

// Constructor Injection
    @Autowired
    public DemoController(
            @Qualifier("swim")
             Coach coach) {
        this.coach = coach;
    }

// Setter Injection
//    @Autowired
//    public void setCoach(@Qualifier("baseballCoach") Coach coach){
//        this.coach = coach;
//    }

    @GetMapping("/dailyworkout")
    public String getDailyWorkout(){
        return coach.getDailyWork();
    }
}
