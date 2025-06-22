package com.learn.components;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class DemoCloudLogAspect {

    @Before("com.learn.components.DemoLoggingAspect.doBeforeExpression() && " +
            "!(com.learn.components.DemoLoggingAspect.getter() || com.learn.components.DemoLoggingAspect.setter())")
    public void DemoLogCloud() {
        System.out.println("Doing some cloud staff");
    }
}
