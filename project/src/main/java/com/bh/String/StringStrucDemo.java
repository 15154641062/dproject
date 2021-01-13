package com.bh.String;

import org.junit.Test;

public class StringStrucDemo {
    @Test
    public  void stringStrucDemoTest(String[] args) {
        String string01=new String();
        System.out.println("string01:"+string01);

        byte[] bytes={1,2,3,4,5,6};
        String string02=new String(bytes);
        System.out.println("string02:"+string02);
        String string03=new String(bytes,0,3);
        System.out.println("string03:"+string03);
        System.out.println("string03.length:"+string03.length());

        char[] chars={'a','b','c','d'};
        String string04=new String(chars);
        System.out.println("string04:"+string04);
        String string05=new String(chars,0,3);
        System.out.println("string05:"+string05);
        System.out.println("string05.length:"+string03.length());

        String string06=new String("String Test");
        System.out.println("String06:"+string06);
    }
}
