package com.learn.components;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.aspectj.lang.annotation.Pointcut;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(1)
public class DemoLoggingAspect {

    @Pointcut("execution(public * *Account())")
    public void doBeforeExpression(){}

    @Pointcut("execution(* get*())")
    public void getter(){}

    @Pointcut("execution(* set*())")
    public void setter(){}

    @Before("doBeforeExpression() && !(getter() || setter())")
    public void DemoBeforeAddAccount(){
        System.out.println("Doing some logging staff");
    }
}
