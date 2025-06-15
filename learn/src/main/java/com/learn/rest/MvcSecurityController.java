package com.learn.rest;

import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MvcSecurityController {

    @GetMapping("/")
    public String homePage(Model model){
        return "home-page";
    }

    @GetMapping("/managers")
    public  String managersPage(){
        return "managers-page";
    }

    @GetMapping("/login")
    public String login(){
        return "login-page";
    }

    @GetMapping("/access-denied")
    public String accessDeniedHandler(){
        return "access-denied";
    }

}
