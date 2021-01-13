package com.bh.string;

import com.bh.pojo.Student;
import org.junit.Test;

import java.util.Scanner;

public class StringMethodDemo {
    @Test
    public void StringMethodDemoTest() {

        method06();


        double db=100+100.0+123L+'a';


        //practice03(new int[]{1,2,3});

        //practice04();

        //System.out.println("practice04():"+practice05("woaijavawozhenaijavawozhendeaijavawozhendehenaijavaxinbuxinwoaijavagun","java"));
    }

    /*public static void main(String[] args) {
        System.out.println("practice04():"+new StringMethodDemo().practice04());
    }*/

    //String 被赋值后就不可改变，这里实际上是重新new了一个String、
    public void method01() {
        String s = "Hello";
        s += " World!";
        System.out.println(s);
    }

    //equals 与 == 的区别
    // == 在比较引用类型的变量时比较的是引用的地址是否相等，String类重写的equals方法比较的是变量的值是否相等
    public void method02() {
        String string01 = "Hello";
        String string01_ = "Hello";
        System.out.println("==:" + (string01 == string01_));   //false
        System.out.println("equals:" + string01.equals(string01_));   //true

        String string02 = "Hello";
        String string02_ = "Hello";
        System.out.println("==:" + (string02 == string02_));   //false
        System.out.println("equals:" + string02.equals(string02_));   //true

        String string03 = "Hello";
        String string03_ = "Hello";
        System.out.println("==:" + (string03 == string03_));   //true
        System.out.println("equals:" + string03.equals(string03_));   //true

        Student student01 = new Student("张三", 12);
        Student student02 = new Student("张三", 12);
        System.out.println("==:" + (student01.toString() == student02.toString()));   //false
        System.out.println("equals:" + student01.toString().equals(student02.toString()));   //true
    }

    //String类的判断功能
    public void method03() {
        String string01 = "hello";
        String string02 = "hello";
        String string03 = "Hello";
        String string04 = "hello world";
        String string05 = null;

        //equals(Object obj)比较两个字符串值是否相等，大小写敏感
        System.out.println("equals():" + string01.equals(string02));  //true
        System.out.println("equals():" + string01.equals(string03));  //false
        //equalsIgnoreCase(String str)比较两个字符串值是否相等，大小写不敏感
        System.out.println("equalsIgnoreCase():" + string01.equalsIgnoreCase(string02));  //true
        System.out.println("equalsIgnoreCase():" + string01.equalsIgnoreCase(string03));  //true
        //contains(String str):判断字符串中是否包含子字符串，大小写敏感
        System.out.println("contains():" + string04.contains(string01));  //true
        System.out.println("contains():" + string04.contains(string03));  //false
        //startsWith(String str):判断字符串是否以某个指定的字符串开头
        System.out.println("startsWith():" + string01.startsWith("h"));   //true
        System.out.println("startsWith():" + string04.startsWith("hello"));   //true
        System.out.println("startsWith():" + string04.startsWith("world"));   //false
        //endsWith(String str):判断字符串是否以某个指定的字符串结尾
        System.out.println("endsWith():" + string01.endsWith("o"));   //true
        System.out.println("endsWith():" + string04.endsWith("hello"));   //false
        System.out.println("endsWith():" + string04.endsWith("world"));   //true
        //isEmpty():判断字符串是否为空
        System.out.println("isEmpty():" + string01.isEmpty());   //false
        System.out.println("isEmpty():" + string05.isEmpty());   //空指针异常，string05为null，没有初始化
    }

    //String类的获取功能
    public void method04() {
        String string01 = "Hello World";

        //int length():获取字符串的长度。
        System.out.println("length():" + string01.length());  //长度为 11
        //charAt(int index):获取指定索引位置的字符
        System.out.println("charAt():" + string01.charAt(0));   //输出字符为 H

        //indexOf(char ch):返回指定字符在此字符串中第一次出现处的索引(从0开始计)
        //indexOf(char ch,int fromIndex):返回从指定位置往后第一次出现处的索引,依旧从字符串开头(下标为0)开始计
        //当找不到时返回-1
        System.out.println("indexOf():" + string01.indexOf('l'));   //输出索引位置序号为 2
        System.out.println("indexOf():" + string01.indexOf('l', 3));   //输出索引位置序号为 3
        System.out.println("indexOf():" + string01.indexOf('g'));   //输出索引位置序号为 -1
        //indexOf(String str):返回指定字符串在此字符串中第一次出现处的索引(从0开始计)
        System.out.println("indexOf():" + string01.indexOf("World"));   //输出索引位置序号为 6

        //substring(int start,int end):从指定位置开始到指定位置结束截取字符串。包括start索引但是不包括end索引
        //从字符串开头(下标为0)开始计，end 不填时默认至字符串结尾
        System.out.println("substring():" + string01.substring(1));   //输出字符串为 ello World
        System.out.println("substring():" + string01.substring(1, 3));   //输出字符串为 el
        System.out.println("substring():" + string01);   //输出字符串为 Hello World
    }

    //统计一个字符串中大写字母字符，小写字母字符，数字字符出现的次数。(不考虑其他字符)
    public void practice01() {
        int bigCount = 0;    //出现大写字母次数
        int smallCount = 0;   //出现小写字母次数
        int numberCount = 0;    //出现数字次数

        System.out.println("请输入一个字符串:");
        //从键盘录入一个字符串
        Scanner scanner = new Scanner(System.in);
        String str = scanner.nextLine();
        if (!str.isEmpty()) {
            for (int i = 0; i < str.length(); i++) {
                char ch = str.charAt(i);
                if (ch >= 'A' && ch <= 'Z') {
                    bigCount++;
                } else if (ch >= 'a' && ch <= 'z') {
                    smallCount++;
                } else if (ch >= '0' && ch <= '9') {
                    numberCount++;
                }
            }
            System.out.println("bigCount:" + bigCount + ",smallCount:" + smallCount + ",numberCount:" + numberCount);
        } else {
            System.out.println("输入的字符串为空！");
        }
    }

    //String的转换功能
    public void method05() {
        String string01 = "Hello World";

        //getBytes():把字符串转换为字节数组
        byte[] bytes = string01.getBytes();
        System.out.print("getBytes():");
        for (int i = 0; i < bytes.length; i++) {
            System.out.print(bytes[i] + " ");
        }
        System.out.print("\n");          //72 101 108 108 111 32 87 111 114 108 100

        //toCharArray():把字符串转换为字符数组。
        char[] chars01 = string01.toCharArray();
        System.out.print("toCharArray():");
        for (int i = 0; i < chars01.length; i++) {
            System.out.print(chars01[i] + " ");
        }
        System.out.print("\n");           //H e l l o   W o r l d

        //valueOf(char[] chs):把字符数组转成字符串。
        char[] chars02 = {'H', 'e', 'l', 'l', 'o'};
        String string02 = String.valueOf(chars02);
        System.out.println("valueOf():" + string02);      //Hello
        //valueOf(int i):把int类型的数据转成字符串。
        int i = 100;
        String string03 = String.valueOf(i);
        System.out.println("valueOf():" + string03);      //100

        //toLowerCase():把字符串转成小写
        System.out.println("toLowerCase():" + string01.toLowerCase());    //hello world
        //toUpperCase():把字符串转成大写
        System.out.println("toUpperCase():" + string01.toUpperCase());    //HELLO WORLD

        //concat(String str):把字符串拼接
        System.out.println("concat():" + string01.concat("!!!"));     //Hello World!!!
    }

    //把一个字符串的首字母转成大写，其余为小写。(只考虑英文大小写字母字符)
    public String practice02(String str) {
        if (!str.isEmpty()) {
            String headStr = str.substring(0, 1).toUpperCase();     //首部转换为大写后的字符串
            String bodyStr = str.substring(1).toLowerCase();     //除首部外转换为小写的字符串
            return headStr.concat(bodyStr);
        } else {
            return "输入的字符串为空！";
        }
    }

    //String类的其他功能
    public void method06() {
        String string01 = " Hello World! ";
        String string02 = "abc";
        String string03 = "ABC";

        //replace(char oldChar,char newChar):将字符串中的所有旧字符替换为新字符
        //replace(String old,String new):将字符串中的所有旧字符串替换为新字符串
        System.out.println("replace():" + string01.replace('!', '.'));     // Hello World.
        System.out.println("replace():" + string01.replace("World!", "World"));    // Hello World

        //trim():去除字符串两端的空格
        System.out.println("trim():" + string01.trim());  //Hello World!

        //按字典顺序比较两个字符串
        // compareTo(String str)
        // compareToIgnoreCase(String str)
        System.out.println("compareTo():" + string02.compareTo(string03));    //
        System.out.println("compareToIgnoreCase():" + string02.compareToIgnoreCase(string03));    //
    }

    /*
     * 需求：把数组中的数据按照指定个格式拼接成一个字符串
     * 举例：
     * 		int[] arr = {1,2,3};
     * 输出结果：
     *		"[1, 2, 3]"
     */
    public String practice03(int[] arr) {
        String str = "[";     //定义一个字符串，并设置初值为"["
        for (int num : arr) {
            str = str + num + ",";    //遍历数组加入字符串中
        }
        str = str.substring(0, str.length() - 1) + "]";    //去除尾部的","并添上"]"
        return str;
    }

    public String practice04() {
        System.out.println("请输入一个字符串:");
        Scanner scanner = new Scanner(System.in);
        String string01 = scanner.nextLine();
        String string02 = "";
        if (!string01.isEmpty()) {
            for (int i = string01.length() - 1; i >= 0; i--) {
                string02 += string01.charAt(i);
            }
            return string02;
        } else {
            return "输入为空！";
        }
    }

    //统计大串中小串出现的次数
    public int practice05(String longStr, String smallStr) {
        int count = 0;
        if (longStr.length() < smallStr.length() || longStr.isEmpty() || smallStr.isEmpty()) {      //数据不符则返回-1
            return -1;
        } else {
            while (longStr.indexOf(smallStr) != -1) {      //大串中能找到小串才继续执行
                count++;
                longStr = longStr.substring(longStr.indexOf(smallStr) + smallStr.length());     //大串裁剪
            }
            return count;
        }
    }
}
