package com.bh.date;

import org.junit.Test;

import java.util.Calendar;
import java.util.Scanner;

public class CalendarDemo {
    @Test
    public void calendarDemoTest() {
        //method01();
        practice01();
    }

    //操作日历字段的一些方法
    public void method01() {
        Calendar calendar = Calendar.getInstance();

        //int get(int field):返回给定日历字段的值
        int year = calendar.get(Calendar.YEAR);   //获取年份
        int month = calendar.get(Calendar.MONTH);   //获取月份
        int date = calendar.get(Calendar.DATE);     //获取日
        System.out.println("Calender() year:" + year + ",month:" + (month+1) + ",date:" + date);

        //add(int field,int amount):根据给定的日历字段和对应的时间，来对当前的日历进行操作
        //10天前的5年后
        calendar.add(Calendar.DATE,-10);
        calendar.add(Calendar.YEAR,5);
        year = calendar.get(Calendar.YEAR);   //获取年份
        month = calendar.get(Calendar.MONTH);   //获取月份
        date = calendar.get(Calendar.DATE);     //获取日
        System.out.println("Calender.add() year:" + year + ",month:" + (month+1) + ",date:" + date);

        //set(int year,int month,int date):设置当前日历的年月日
        calendar.set(2021,2,14);
        year = calendar.get(Calendar.YEAR);   //获取年份
        month = calendar.get(Calendar.MONTH);   //获取月份
        date = calendar.get(Calendar.DATE);     //获取日
        System.out.println("Calender.set() year:" + year + ",month:" + month + ",date:" + date);
    }

    //获取任意一年的二月有多少天
    public void practice01(){
        Calendar calendar = Calendar.getInstance();

        System.out.println("请输入一个年份:");
        //Scanner scanner=new Scanner(System.in);
        //int year=scanner.nextInt();       //从键盘输入一个年份
        int year=2021;

        calendar.set(year,2,1);     //设置日历
        calendar.add(Calendar.DATE,-1);     //日历天数减一就是当年2月份的最后一天

        int month = calendar.get(Calendar.MONTH);   //获取月份
        int date = calendar.get(Calendar.DATE);     //获取日


        System.out.println(year + "年的" + (month+1) + "月有" + date+"天");      //打印
    }
}
