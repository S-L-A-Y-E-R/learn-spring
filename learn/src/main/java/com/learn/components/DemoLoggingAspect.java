package com.learn.components;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.stereotype.Component;

@Aspect
@Component
public class DemoLoggingAspect {

    @Before("execution(public void *Account(..))")
    public void DemoBeforeAddAccount(){
        System.out.println("Doing some staff before adding account");
    }
}
