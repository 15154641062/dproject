package com.bh.date;

import org.junit.Test;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Scanner;

public class DateDemo {
    @Test
    public void dateDemoTest() throws ParseException {
        //struMethod();
        //timeMethod();
        //formatTimeMethod();
        myYearOldMethod();
    }

    //构造方法
    public void struMethod() {
        //Date():根据当前的默认毫秒值创建日期对象
        //Date(long date)：根据给定的毫秒值创建日期对象
        Date date01 = new Date();
        Date date02 = new Date(1000 * 60 * 60);   //1 hour
        System.out.println(date01);
        System.out.println(date02);     //Thu Jan 01 09:00:00 CST 1970
    }

    //获取、设置time
    public void timeMethod() {
        Date date = new Date();   //创建对象

        //long getTime():获取时间，以毫秒为单位
        long time = date.getTime();
        System.out.println("getTime():" + time);
        System.out.println(System.currentTimeMillis());     //也是返回当前时间的毫秒值

        //public void setTime(long time):设置时间
        date.setTime(1000 * 60 * 60);
        System.out.println("setTime():" + date);  //Thu Jan 01 09:00:00 CST 1970
    }

    //格式化、解析日期时间
    public void formatTimeMethod() throws ParseException {
        Date date = new Date();

        //Date--String(格式化)
        //public final String format (Date date)    将Date格式化为String字符串
        //SimpleDateFormat 为DateFormat抽象类的一个具体的实现类，可使用该类中的format方法格式化日期
        SimpleDateFormat simpleDateFormat01 = new SimpleDateFormat("yyyyMMdd HH:mm:ss");
        String timeStr = simpleDateFormat01.format(date);
        System.out.println(timeStr);

        //String--Date(解析)
        //public Date parse (String source)     将String字符串解析为Date
        String time = "2021-01-13 14:36:58";
        SimpleDateFormat simpleDateFormat02 = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        date = simpleDateFormat02.parse(time);
        System.out.println("SimpleDateFormat.parse():" + date);
    }

    //计算你来到这个世界多少天
    public void myYearOldMethod() throws ParseException {
        System.out.println("请输入你的出生日期(格式：yyyyMMdd):");
        //Scanner scanner = new Scanner(System.in);
        //String birthDay = scanner.nextLine();     //从键盘录入出生日期
        String birthDay="19980607";

        Date birthDate = new SimpleDateFormat("yyyyMMdd").parse(birthDay);   //格式化String日期为Date
        Date curDate = new Date();

        long liveTime = curDate.getTime() - birthDate.getTime();    //现时间减去出生日期的差值
        long liveDay = liveTime / 1000 / 60 / 60 / 24;      //转化为天数
        System.out.println("你已经出生 " + liveDay + " 天了");
    }

}
