package com.bh.throwable;

public class Teacher {
    public void check(int score) throws MyException {
        if(score>100 || score<0) {
            throw new MyException("成绩超出0-100范围");  //由于此处抛出的异常是非运行时异常，那么必须处理
        }else {
            System.out.println("成绩正常");
        }
    }
}
