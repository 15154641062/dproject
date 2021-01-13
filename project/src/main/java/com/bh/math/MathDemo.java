package com.bh.math;

import org.junit.Test;

import java.util.Random;

public class MathDemo {
    @Test
    public void mathDemoTest() {
        //method();
        System.out.println("获取指定范围内的随机数:"+practice01());
    }

    //Math类成员方法
    public void method() {
        //double PI  圆周率
        System.out.println("PI:" + Math.PI);    //3.141592653589793
        //double E   自然底数 e
        System.out.println("E:" + Math.E);      //2.718281828459045

        //int abs(int a): 返回数字的绝对值
        System.out.println("abs:" + Math.abs(10));      //10
        System.out.println("abs:" + Math.abs(-10));     //10

        //double ceil(double a): 向上取整 3.1->4.0
        System.out.println("ceil():" + Math.ceil(3.1));     //4.0

        //double floor(double a):  向下取整   3.9->3.0
        System.out.println("floor():" + Math.floor(3.9));     //3.0

        //int max(int a,int b): 返回两个数的最大值
        System.out.println("max:" + Math.max(1, 2));    //2
        //例子: 获取三个数据中的最大值
        System.out.println("max:" + Math.max(Math.max(1, 2), 3));     //3
        //例子: 获取四个数据中的最大值
        System.out.println("max:" + Math.max(Math.max(1, 2), Math.max(3, 4)));     //4

        //double pow(double a,double b):  返回a的b次幂
        System.out.println("pow():" + Math.pow(3, 2));      //9.0

        //double random():产生一个随机数 [0.0,1.0)  包含0 不包含1.0
        System.out.println("random():" + Math.random());
        //获取一个1-100之间的随机数
        System.out.println("random():" + ((int) (Math.random() * 100) + 1));

        //int round(float a) 四舍五入
        System.out.println("round():" + Math.round(12.34f));    //12
        System.out.println("round():" + Math.round(12.56f));    //13
        //int round(double a) 四舍五入
        System.out.println("round():" + Math.round(12.34));     //12
        System.out.println("round():" + Math.round(12.56));     //13

        //double sqrt(double a):  返回正平方根
        System.out.println("sqrt():" + Math.sqrt(4));       //2.0
    }

    //获取任意范围内的随机数
    //起: m  止:n   m+Random.(n-m+1)
    public int practice01(){
        int Start=20;   //起
        int end=50;    //止
        return 20+new Random().nextInt(end-Start+1);
    }
}
