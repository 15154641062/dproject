package com.bh.collection;

import com.bh.pojo.Student;
import org.junit.Test;

import java.util.*;

public class ListDemo {
    @Test
    public void listDemoTest(){
        //method01();
        method02();
    }

    /*
    * List集合特点
    * 有序:遍历时取出元素的顺序和存入时一致
    * 可重复:元素的值可重复
    * */
    //遍历List集合
    public void method01(){
        List list01 = new ArrayList();

        list01.add("Hello");
        list01.add("World");
        list01.add("!");
        list01.add("!");

        // Iterator 遍历List集合
        Iterator iterator = list01.iterator();
        while (iterator.hasNext()) {        //是否还有下一个
            String str = (String) iterator.next();      //next()方法返回当前位置处元素并向后移动
            System.out.println(str);
        }

        //存储自定义对象并遍历
        List list02 = new ArrayList();
        Student s1=new Student("张三",21);
        Student s2=new Student("李四",23);
        Student s3=new Student("王五",25);
        list02.add(s1);
        list02.add(s2);
        list02.add(s3);

        iterator=list02.iterator();
        while (iterator.hasNext()){      //是否还有下一个
            System.out.println(iterator.next());     //next()方法返回当前位置处元素并向后移动
        }
    }

    //List集合特有的功能
    public void method02(){
        List list01 = new ArrayList();

        //void add(int index,Object element):在指定位置添加元素
        try {
            list01.add("Hello");
            list01.add(1,"World");      //index 需小于当前list 集合的大小
            logListByListIterator(list01);
        }catch (IndexOutOfBoundsException ex){
            System.out.println("输入的数组下标越界!");
        }

        //Object get(int index):获取指定位置的元素
        System.out.println("get():"+list01.get(1));     //World

        //remove(int index)：根据索引删除元素,返回被删除的元素
        System.out.println("remove():"+list01.remove(1));     //World
        logListByListIterator(list01);      //Hello

        //set(int index,Object element):根据索引修改元素，返回被修饰的元素
        System.out.println("set():"+list01.set(0,"World"));     //Hello
        logListByListIterator(list01);      //World
    }

    //ListIterator listIterator()：List集合特有的迭代器  打印List集合
    //ListIterator可以实现逆向遍历，但是必须先正向遍历，才能逆向遍历，所以一般无意义，不使用
    public void logListByListIterator(List list){
        ListIterator listIterator=list.listIterator();      //创建迭代器对象
        while (listIterator.hasNext()){      //是否还有下一个
            System.out.println(listIterator.next());     //next()方法返回当前位置处元素并向后移动   打印
        }
    }


}
