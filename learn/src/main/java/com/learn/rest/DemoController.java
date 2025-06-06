package com.learn.rest;

import com.learn.Coach;
import jakarta.servlet.http.HttpServletRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import com.learn.pojo.Name;

import java.time.Instant;

@Controller
public class DemoController {
//Field Injection
//@Qualifier("baseballCoach")
//@Autowired
//    private final Coach coach;

// Constructor Injection
//    @Autowired
//    public DemoController(
//            @Qualifier("swim")
//             Coach coach) {
//        this.coach = coach;
//    }

// Setter Injection
//    @Autowired
//    public void setCoach(@Qualifier("baseballCoach") Coach coach){
//        this.coach = coach;
//    }

//    @GetMapping("/dailyworkout")
//    public String getDailyWorkout(){
//        return coach.getDailyWork();
//    }

    @GetMapping("/hello")
    public String setThymeleafTime(Model model){
        model.addAttribute("time", Instant.now());
        return "helloWorld";
    }

    @GetMapping("/showForm")
    public String showForm(Model model){
        model.addAttribute("name",new Name());
        return "helloWorldForm";
    }

    @PostMapping("/processForm")
    public String processFom( @ModelAttribute("name") Name name){
        return "processForm";
    }
}
