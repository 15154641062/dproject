package com.bh.innerclass;

import org.junit.Test;

public class InnerClassDemo {
    @Test
    public void innerClassDemoTest(){
        //传统多态方式，实现类实现接口，
        PersonDemo personDemo = new PersonDemo();
        Person person = new Student();
        personDemo.method(person);

        //匿名内部类  通过匿名的方式继承并重写了方法，等同于创建了一个实现类并创建了其对象
        personDemo.method(new Person() {
            @Override
            public void study() {
                System.out.println("我超爱学习的！");
            }
        });
    }
}
