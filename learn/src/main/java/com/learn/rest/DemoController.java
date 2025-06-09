package com.learn.rest;

import com.learn.Coach;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.beans.propertyeditors.StringTrimmerEditor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.WebDataBinder;
import org.springframework.web.bind.annotation.*;
import com.learn.pojo.Name;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

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
    public String showForm(Model model,@Value("${countries}") List<String> countries){
        model.addAttribute("name",new Name());
        model.addAttribute("countries",countries);
        return "helloWorldForm";
    }

    @PostMapping("/processForm")
    public String processFom(@Valid @ModelAttribute("name") Name name, BindingResult bindingResult){
        if(bindingResult.hasErrors()){
            return "helloWorldForm";
        }else {
            return "processForm";
        }
    }

    @InitBinder
    public void initBinder(WebDataBinder binder){
        StringTrimmerEditor trimmerEditor = new StringTrimmerEditor(true);
        binder.registerCustomEditor(String.class,trimmerEditor);
    }
}
