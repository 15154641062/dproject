package com.bh.myspring.pojo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Required;
import org.springframework.stereotype.Component;

public class User {
    private String name;
    private int age;

    @Autowired
    public User() {
        System.out.println("User Structure...");
    }


    public User(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    @Required
    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    @Required
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "User{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }

    public void init(){
        System.out.println("bean init...");
    }

    public void destroy(){
        System.out.println("bean destroy...");
    }
}
