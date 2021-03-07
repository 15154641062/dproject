package com.bh.myspring.entity;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

public class Vehicle {

    private String name;
    @Autowired
    private Car car;

    public Vehicle(){
        System.out.println("Vehicle Structure...");
    }

//    public Vehicle(Car car){
//        this.car=car;
//    }

    public void toSay(){
        car.say();
    }
}
