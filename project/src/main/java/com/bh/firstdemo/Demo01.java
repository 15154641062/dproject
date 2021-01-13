package com.bh.firstdemo;

import java.math.BigDecimal;
import java.util.Arrays;

public class Demo01 {
    static int num=1;
    public static void main(String[] args) {
        Demo01 demo01=new Demo01();
        /*for (; num <3 ; num++) {
            System.out.println(num);
        }

        System.out.println("==========================");

        for (; num <3 ; num++) {
            System.out.println(num);
        }*/
        int number1=10;
        int number2=20;
        demo01.swapByTemp(number1,number2);
        System.out.println("main()方法内：number1="+number1+",number2="+number2);

        demo01.swap(number1,number2);
        System.out.println("main()方法内：number1="+number1+",number2="+number2);

        int[] array={9,7,5,3,1};
        System.out.println("array数组排序前:"+ Arrays.toString(array));
        demo01.sort(array);
        System.out.println("array数组排序后:"+Arrays.toString(array));

        System.out.println("array数组add前:"+ Arrays.toString(array));
        demo01.add(array);
        System.out.println("array数组add后:"+Arrays.toString(array));

        double double1=0.09;
        double double2=0.01;
        System.out.println(double1+double2);

        BigDecimal bigDecimal1=new BigDecimal("0.09");
        BigDecimal bigDecimal2=new BigDecimal("0.01");
        System.out.println(bigDecimal1.add(bigDecimal2));


    }

    //交换(使用中间变量)
    public void swapByTemp(int number1,int number2){
        int temp=number1;
        number1=number2;
        number2=temp;
        System.out.println("swapByTemp()方法内：number1="+number1+",number2="+number2);
    }

    //交换(不使用中间变量)
    public void swap(int number1,int number2){
        number1=number1+number2;
        number2=number1-number2;
        number1=number1-number2;
        System.out.println("swap()方法内：number1="+number1+",number2="+number2);
    }

    //排序
    public void sort(int[] array){
        int temp;
        for (int i = 0; i < array.length-1; i++) {
            for (int j = 0; j < array.length-i-1; j++) {
                if(array[j]>array[j+1]){
                    temp=array[j];
                    array[j]=array[j+1];
                    array[j+1]=temp;
                }
            }
        }
    }

    public void add(int[] array){
        //遍历数组
        for(int i = 0;i<array.length;i++){
            array[i] += 10;
        }
        //打印
        System.out.println("add()方法内array:"+Arrays.toString(array));
    }

}
