package com.sap.spring5.aopanno;

import org.aspectj.lang.annotation.Aspect;
import org.springframework.stereotype.Component;

@Component
public class User {

    public void add(){
//        int a  = 1/0;
        System.out.println("add....");
    }
}
