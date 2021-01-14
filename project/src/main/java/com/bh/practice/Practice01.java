package com.bh.practice;

import org.junit.Test;
import sun.nio.cs.ext.GBK;

import java.io.UnsupportedEncodingException;
import java.util.Arrays;

//20200113
public class Practice01 {
    @Test
    public void practice01Test() throws UnsupportedEncodingException {
        String str="社会主义核心价值观";
        char[] chars01=new char[9];
        str.getChars(0,str.length(),chars01,0);
        System.out.println("getChars():"+Arrays.toString(chars01));
        char[] chars02=str.toCharArray();
        System.out.println("toCharArray():"+Arrays.toString(chars02));

        byte[] bytes=str.getBytes("GBK");
        System.out.println(Arrays.toString(bytes));
    }
}
