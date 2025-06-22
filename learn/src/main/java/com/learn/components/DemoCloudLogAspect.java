package com.learn.components;

import org.aspectj.lang.annotation.Aspect;
import org.aspectj.lang.annotation.Before;
import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

@Aspect
@Component
@Order(2)
public class DemoCloudLogAspect {

    @Before("com.learn.components.DemoPointcutExpressions.doBeforeExpression() && " +
            "!(com.learn.components.DemoPointcutExpressions.getter() || com.learn.components.DemoPointcutExpressions.setter())")
    public void DemoLogCloud() {
        System.out.println("Doing some cloud staff");
    }
}
