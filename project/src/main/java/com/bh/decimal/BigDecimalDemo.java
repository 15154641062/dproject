package com.bh.decimal;

import org.junit.Test;

import java.math.BigDecimal;

public class BigDecimalDemo {
    @Test
    public void bigDecimalDemoTest(){
        calculateMethod();
    }

    //BigDecimal运算
    public void calculateMethod(){
        //BigDecimal(String val):构造方法
        BigDecimal bigDecimal01=new BigDecimal("0.09");
        BigDecimal bigDecimal02=new BigDecimal("0.01");

        //add(BigDecimal augend):加
        System.out.println("add():"+bigDecimal01+" + "+bigDecimal02+" = "+bigDecimal01.add(bigDecimal02));  //0.10

        //subtract(BigDecimal subtrahend):减
        System.out.println("subtract():"+bigDecimal01+" - "+bigDecimal02+" = "+bigDecimal01.subtract(bigDecimal02));  //0.08

        //Dmultiply(BigDecimal multiplicand):乘
        System.out.println("multiply():"+bigDecimal01+" * "+bigDecimal02+" = "+bigDecimal01.multiply(bigDecimal02));  //0.08

        //divide(BigDecimal divisor):除
        //divide(BigDecimal divisor,int scale,int roundingMode):商，几位小数，如何舍取
        //ROUND_UP：向正无穷方向对齐（转换为正无穷方向最接近的所需数值）
        //ROUND_DOWN：向负无穷方向对齐
        //ROUND_CEILING：向原点的反方向对齐
        //ROUND_FLOOR：向原点方向对齐
        //ROUND_HALF_UP：“四舍五入”，如果舍弃部分的最高位大于等于 5，向正无穷方向对齐，否则向负无穷方向对齐
        //ROUND_HALF_DOWN：“五舍六入”，如果舍弃部分的最高位大于 5，向正无穷方向对齐，否则向负无穷方向对齐
        //ROUND_HALF_EVEN：“四舍六入五成双”，如果舍弃部分的最高位大于等于六，或等于五并且前一位是奇数，向正无穷方向对齐，否则向负无穷方向对齐
        //ROUND_UNNECESSARY：如果需要舍入，就抛出算术异常
        System.out.println("divide():"+bigDecimal01+" / "+bigDecimal02+" = "+bigDecimal01.divide(bigDecimal02));
        System.out.println("divide():"+bigDecimal01+" / "+bigDecimal02+" = "+bigDecimal01.divide(bigDecimal02,2,BigDecimal.ROUND_HALF_UP));
    }


}
