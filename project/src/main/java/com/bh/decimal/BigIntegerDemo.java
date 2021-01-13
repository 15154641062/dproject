package com.bh.decimal;

import org.junit.Test;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.Arrays;

public class BigIntegerDemo {
    @Test
    public void bigIntegerDemoTest(){
        calculateMethod();
    }

    //BigInteger运算
    public void calculateMethod(){
        //BigInteger(String val):构造方法
        BigInteger bigInteger01=new BigInteger("100");
        BigInteger bigInteger02=new BigInteger("200");

        //add(BigInteger augend):加
        System.out.println("add():"+bigInteger01+" + "+bigInteger02+" = "+bigInteger01.add(bigInteger02));  //300

        //subtract(BigInteger subtrahend):减
        System.out.println("subtract():"+bigInteger01+" - "+bigInteger02+" = "+bigInteger01.subtract(bigInteger02));  //-100

        //Dmultiply(BigInteger multiplicand):乘
        System.out.println("multiply():"+bigInteger01+" * "+bigInteger02+" = "+bigInteger01.multiply(bigInteger02));  //20000

        //divide(BigInteger divisor):除
        System.out.println("divide():"+bigInteger01+" / "+bigInteger02+" = "+bigInteger02.divide(bigInteger02));    //1

        //BigInteger[] divideAndRemainder(BigInteger val):返回商和余数的数组
        System.out.println("divideAndRemainder():"+ Arrays.toString(bigInteger01.divideAndRemainder(bigInteger02)));    //[0, 100]
    }
}

