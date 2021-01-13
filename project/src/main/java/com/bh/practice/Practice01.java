package com.bh.practice;

import org.junit.Test;

import java.util.Arrays;

//20200113
public class Practice01 {
    @Test
    public void practice01Test(){
        String str="济南大学信息科学与工程学院";
        char[] chars=new char[13];
        str.getChars(0,str.length(),chars,0);
        System.out.println(Arrays.toString(chars));
    }
}
