package com.learn.components;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.annotation.AfterReturning;
import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;

@Aspect
@Component
@Order(1)
public class DemoLoggingAspect {

    @Before("com.learn.components.DemoPointcutExpressions.doBeforeExpression() &&" +
            " !(com.learn.components.DemoPointcutExpressions.getter() || " +
            "com.learn.components.DemoPointcutExpressions.setter())")
    public void DemoBeforeAddAccount(JoinPoint joinPoint){
        var args = joinPoint.getArgs();
        System.out.println("Doing some logging staff");
        Arrays.stream(args).forEach(System.out::println);
    }

    @AfterReturning(pointcut = "com.learn.components.DemoPointcutExpressions.doAfterExpression()",
        returning = "result"
    )
    public void DemoAfterRetrievingAccounts(JoinPoint joinPoint, List<String> result){
        System.out.println("Doing some staff after RetrievingAccounts");
        System.out.println(result);
    }
}
