package com.learn.components;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;

import org.springframework.core.annotation.Order;
import org.springframework.stereotype.Component;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.TimeUnit;

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

    @AfterThrowing(pointcut = "com.learn.components.DemoPointcutExpressions.doAfterThrowingExpression()",
        throwing = "exception"
    )
    public void doSomeStaffAfterThrowing(JoinPoint joinPoint,Throwable exception){
        System.out.println(exception.getMessage());
    }

    @After("com.learn.components.DemoPointcutExpressions.doAfterFinallyExpression()")
    public void doSomeStaffAfterFinally(){
        System.out.println("Doing some staff after finally");
    }

//    @Around("com.learn.components.DemoPointcutExpressions.doAroundExpression()")
//    public Object calculateTimeTakenForExecution(ProceedingJoinPoint proceedingJoinPoint) throws
//            Throwable {
//        Object result = null;
//        long begin = System.currentTimeMillis();
//        try{
//             result = proceedingJoinPoint.proceed();
//        }catch (Exception exception){
//            System.out.println("Nothing important. Move along!");
//        }
//        TimeUnit.SECONDS.sleep(3);
//        long end = System.currentTimeMillis();
//        long duration = end - begin;
//        System.out.println("Time taken for the execution in seconds "+ duration/1000);
//        return result;
//    }

    @Around("com.learn.components.DemoPointcutExpressions.doAfterFinallyExpression()")
    public Object rethrowExceptionFromAround(ProceedingJoinPoint proceedingJoinPoint) throws
            Throwable{
        try{
            return proceedingJoinPoint.proceed();
        }catch (Exception exception){
            System.out.println("Exception thrown from the around");
            throw exception;
        }
    }
}
