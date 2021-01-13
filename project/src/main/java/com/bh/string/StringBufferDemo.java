package com.bh.string;

import org.junit.Test;

public class StringBufferDemo {
    @Test
    public void StringBufferDemoTest(){
        //stringBufferStru();
        //addMethod();
        //deleteMethod();
        //reverseMethod();
        //substringMethod();
        //transMethod();
        stringbufferTest();
    }

    public void stringBufferStru(){
        //StringBuffer():无参构造方法
        StringBuffer stringBuffer01=new StringBuffer();
        System.out.println("StringBuffer():"+stringBuffer01);      //
        //StringBuffer(String str):创建指定字符串内容的字符串缓冲区对象
        StringBuffer stringBuffer02=new StringBuffer("Hello");
        System.out.println("StringBuffer(String str):"+stringBuffer02.length());
        //StringBuffer(int capacity):创建指定容量的字符串缓冲区对象
        StringBuffer stringBuffer03=new StringBuffer(3);
        System.out.println("StringBuffer(int capacity).capacity():"+stringBuffer03.capacity());     //3

        //capacity():返回当前容量	理论值
        //length():返回长度（字符数） 实际值
    }

    //StringBuffer类的添加方法
    public void addMethod(){
        StringBuffer stringBuffer01=new StringBuffer();

        //append(String str):可以把任意类型数据添加到字符串缓冲区,并返回字符串缓冲区本身
        StringBuffer stringBuffer02=stringBuffer01.append("Hello");
        System.out.println("append():"+stringBuffer01);     //Hello
        System.out.println(stringBuffer01==stringBuffer02);     //true

        //insert(int offset,String str):在指定位置把任意类型的数据插入到字符串缓冲区里面,并返回字符串缓冲区本身
        stringBuffer01.insert(5,"World");
        System.out.println("insert():"+stringBuffer01);     //HelloWorld

        //链式编程  返回值是一个对象即可继续进行链式编程
        stringBuffer01.append(true).append(12).append(34.56);
        System.out.println("链式编程:"+stringBuffer01);     //HelloWorldtrue1234.56
    }

    //StringBuffer的删除功能
    public void deleteMethod(){
        StringBuffer stringBuffer01=new StringBuffer("HelloWorld!");

        //deleteCharAt(int index):删除指定位置的字符，并返回本身
        stringBuffer01.deleteCharAt(10);
        System.out.println("deleteCharAt():"+stringBuffer01);   //HelloWorld
        //delete(int start,int end):删除从指定位置开始指定位置结束的内容，并返回本身
        // (删除的内容包含start处的不包含end处的)
        stringBuffer01.delete(5,10);
        System.out.println("delete():"+stringBuffer01);   //Hello
        stringBuffer01.delete(0,stringBuffer01.length());       //删除所有字符

    }

    //StringBuffer的反转功能
    public void reverseMethod(){
        StringBuffer stringBuffer01 = new StringBuffer();

        stringBuffer01.append("abc");
        System.out.println("stringBuffer01:" + stringBuffer01);
        //reverse():反转字符串
        stringBuffer01.reverse();
        System.out.println("reverse():" + stringBuffer01);  //cba
    }

    //StringBuffer的截取功能(注意返回值类型不再是StringBuffer本身了)
    public void substringMethod(){
        StringBuffer stringBuffer01 = new StringBuffer("HelloWorld");
        //substring(int start)
        //substring(int start,int end):指定开始和结束位置截取字符串，包含start不包含end处的字符
        System.out.println("substring(int start):"+stringBuffer01.substring(5));    //World
        System.out.println("substring(int start):"+stringBuffer01.substring(0,5));      //Hello
    }

    //String与StringBuffer的相互转化
    public void transMethod(){
        StringBuffer stringBuffer01 = new StringBuffer("Hello");
        // 方式1:通过构造方法
        String string01 = new String(stringBuffer01);
        // 方式2：通过toString()方法
        String string02 = stringBuffer01.toString();
        System.out.println("通过构造--string01:" + string01);
        System.out.println("通过toString--string02:" + string02);
    }

    public void stringbufferTest() {
        /*
        * StringBuffer为引用传递，String为值传递，但更准确的说法是，StringBuffer传递的值为参数的地址，
        * 即把参数的地址的值复制一份传给形参，相当于拿到了可以修改传入参数值的钥匙，
        * 当在此方法内对Stringbuffer的形参赋值为第二个StringBuffer形参时，
        * 此时第一个形参的地址拷贝变更为第二个参数的地址拷贝，即两个形参都拿到的是第二个StringBuffer参数的地址的拷贝，
        * 本质上是相等的，此时无论在方法内修改哪一个StringBuffer形参，都会将相应的改动反应到第二个参数上，
        * 而不会对第一个参数产生任何影响。
        */
        String s1 = "hello";
        String s2 = "world";
        System.out.println(s1 + "---" + s2);// hello---world
        change(s1, s2);
        System.out.println(s1 + "---" + s2);// hello---world

        StringBuffer sb1 = new StringBuffer("hello");
        StringBuffer sb2 = new StringBuffer("world");
        System.out.println(sb1 + "---" + sb2);// hello---world
        change(sb1, sb2);
        System.out.println(sb1 + "---" + sb2);// hello---worldworld

    }

    public void change(StringBuffer sb1, StringBuffer sb2) {
        sb1 = sb2;
        sb1.append(sb1);
        System.out.println(sb1 + "---" + sb2);// hello---worldworld
    }

    public void change(String s1, String s2) {
        s1 = s2;
        s2 = s1 + s2;
    }
}
