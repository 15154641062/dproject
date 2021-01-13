package com.bh.innerclass;

public class PersonDemo {
    //接口名作为形式参数
    //其实这里需要的不是接口，而是该接口的实现类的对象
    public void method(Person p) {
        p.study();
    }
}
