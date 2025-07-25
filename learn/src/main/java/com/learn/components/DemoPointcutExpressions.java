package com.learn.components;

import org.aspectj.lang.annotation.Pointcut;

public class DemoPointcutExpressions {
    @Pointcut("execution(public * *Account(..))")
    public void doBeforeExpression(){}

    @Pointcut("execution(* get*(..))")
    public void getter(){}

    @Pointcut("execution(* set*(..))")
    public void setter(){}

    @Pointcut("execution(* *Accounts(..))")
    public void doAfterExpression(){}

    @Pointcut("execution(* *Account(..))")
    public void doAfterThrowingExpression(){}

    @Pointcut("execution(* *Account(..))")
    public void doAfterFinallyExpression(){}

    @Pointcut("execution(* *Account(..))")
    public void doAroundExpression(){}
}
