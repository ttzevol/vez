package com.vez.aop;

import org.aspectj.lang.JoinPoint;
import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

/**
 * @description: springboot面向切面示例
 * @Aspect表示这是一个切面类
 * @author: wubowen
 * @date: 2021/1/25 0025 15:05
 */
@Component
@Aspect
public class LogAspect {
    //切入点定义
    //第一个*表示返回任意的值
    //第二个*表示service包下的任意类
    //第三个*表示service所有包下的所有类
    @Pointcut("execution(* com.vez.service.*.*(..))")
    public void pc1(){

    }

    //该方法在目标方法执行之前执行
    @Before(value = "pc1()")
    public void before(JoinPoint jp){
        String name = jp.getSignature().getName();
        System.out.println(name + "方法开始执行...");
    }

    //该方法在目标方法执行之后执行
    @After(value = "pc1()")
    public void after(JoinPoint jp){
        String name = jp.getSignature().getName();
        System.out.println(name + "方法执行结束...");
    }

    //该方法中可以获取目标方法的返回值，returning是指返回值的变量名
    @AfterReturning(value = "pc1()", returning = "result")
    public void afterReturning(JoinPoint jp, Object result){
        String name = jp.getSignature().getName();
        System.out.println(name + "方法返回值为：" + result);
    }

    //异常通知，当目标发生异常时，该方法会被调用，可以限定exception的类型
    @AfterThrowing(value = "pc1()", throwing = "e")
    public void afterThrowing(JoinPoint jp, Exception e){
        String name = jp.getSignature().getName();
        System.out.println(name + "方法抛异常了，异常是：" + e.getMessage());
    }

    //环绕通知，通过调用ProceedingJoinPoint对象的proceed方法继续执行
    //开发者可以在此修改目标方法的执行参数、返回值等
    @Around("pc1()")
    public Object arround(ProceedingJoinPoint pjp) throws Throwable{
        return pjp.proceed();
    }

}
