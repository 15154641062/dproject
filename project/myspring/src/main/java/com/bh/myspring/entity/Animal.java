package com.bh.myspring.entity;

import org.springframework.stereotype.Component;

public class Animal {
    private Cat cat;
//    public Animal(Cat cat){
//        System.out.println("Animal Structure...");
//        this.cat=cat;
//    }

    public void setCat(Cat cat){
        this.cat=cat;
    }

    public Cat getCat(){
        return cat;
    }

    public void toSay(){
        cat.say();
    }
}
