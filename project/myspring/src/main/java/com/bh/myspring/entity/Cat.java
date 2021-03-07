package com.bh.myspring.entity;

import org.springframework.aop.scope.ScopedProxyUtils;
import org.springframework.stereotype.Component;

public class Cat {
    public Cat(){
        System.out.println("Cat Structure...");
    }

    public void say(){
        System.out.println("This is a Cat...");
    }
}
