package com.sap.spring5.aopanno;


import org.aspectj.lang.ProceedingJoinPoint;
import org.aspectj.lang.annotation.*;
import org.springframework.stereotype.Component;

@Component
@Aspect
public class UserProxy {

    @Pointcut(value ="execution(* com.sap.spring5.aopanno.User.add(..))" )
    public void tttt(){}

    @Before(value = "tttt()")
    public void before(){
        System.out.println("before....");
    }


    @After(value = "execution(* com.sap.spring5.aopanno.User.add(..))")
    public void after(){
        System.out.println("after....");
    }


    @AfterReturning(value = "execution(* com.sap.spring5.aopanno.User.add(..))")
    public void afterReturning(){
        System.out.println("afterReturning....");
    }

    @AfterThrowing(value = "execution(* com.sap.spring5.aopanno.User.add(..))")
    public void afterThrowing(){
        System.out.println("afterThrowing....");
    }

    @Around(value = "execution(* com.sap.spring5.aopanno.User.add(..))")
    public void around(ProceedingJoinPoint proceedingJoinPoint) throws Throwable {

        System.out.println("around....");

        proceedingJoinPoint.proceed();

        System.out.println("after around ....");
    }

}
