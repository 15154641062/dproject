package com.bh.collection;

import com.bh.pojo.Student;
import org.junit.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;

public class CollectionDemo {
    @Test
    public void collectionDemoTest(){
        //method01();
        //method02();
        method03();
        //method04();

    }

    //集合类的添加、删除功能
    public void method01(){
        Collection collection01=new ArrayList();

        //int size():元素的个数   集合无length方法
        //boolean add(Object obj):添加一个元素
        System.out.println("add(\"123\"):"+collection01.add("123"));
        System.out.println("collection01.size():"+ collection01.size());
        System.out.println("add(\"Hello\"):"+collection01.add("Hello"));
        System.out.println("collection01.size():"+ collection01.size());
        //boolean addAll(Collection c):添加一个集合的元素
        Collection collection02=new ArrayList();
        System.out.println("addAll():"+collection02.addAll(collection01));
        System.out.println("collection02.size():"+ collection02.size());

        collection01.add("456");
        collection02.add("World");
        //removeAll(Collection c):移除一个集合的元素
        //移除collection02中存在于collection01的所有元素   未发生过移除则返回false
        System.out.println("removeAll():"+collection02.removeAll(collection01));
        System.out.println("collection02.size():"+ collection02.size());

        //remove(Object o):移除一个元素
        System.out.println("remove(\"12345\"):"+collection01.remove("12345"));
        System.out.println("collection01.size():"+ collection01.size());
        System.out.println("remove(\"123\"):"+collection01.remove("123"));
        System.out.println("collection01.size():"+ collection01.size());
        System.out.println("remove(\"Hello\"):"+collection01.remove("Hello"));
        System.out.println("collection01.size():"+ collection01.size());

        //void clear():移除所有元素
        collection01.clear();
        System.out.println("clear():"+collection01.size());
    }

    //集合类的判断功能
    public void method02(){
        Collection collection01=new ArrayList();
        Collection collection02=new ArrayList();
        collection01.add("1");
        collection01.add("2");
        collection02.addAll(collection01);
        collection01.add("3");
        collection02.add("4");

        //contains(Object o)：判断集合中是否包含指定的元素
        System.out.println("contains(\"1\"):"+collection01.contains("1"));
        System.out.println("contains(\"4\"):"+collection01.contains("4"));
        //containsAll(Collection c)：判断集合中是否包含指定的集合元素
        //仅当集合中包含 c 中的所有元素时才返回true
        System.out.println("containsAll():"+collection02.containsAll(collection01));
        collection02.add("3");
        System.out.println("containsAll():"+collection02.containsAll(collection01));

        //isEmpty()：判断集合是否为空
        collection01.clear();
        System.out.println("isEmpty():"+collection01.isEmpty());
    }

    //获取功能 Iterator遍历集合
    public void method03(){
        Collection collection01=new ArrayList();
        collection01.add("1");
        collection01.add("2");
        collection01.add("3");

        //Iterator<E> iterator()  返回一个Iterator对象
        Iterator iterator=collection01.iterator();
        while (iterator.hasNext()){      //是否还有下一个
            System.out.println(iterator.next());     //next()方法返回当前位置处元素并向后移动
        }

        Collection collection02=new ArrayList();
        Student s1=new Student("张三",21);
        Student s2=new Student("李四",23);
        Student s3=new Student("王五",25);
        collection02.add(s1);
        collection02.add(s2);
        collection02.add(s3);

        iterator=collection02.iterator();
        while (iterator.hasNext()){      //是否还有下一个
            System.out.println(iterator.next());     //next()方法返回当前位置处元素并向后移动
        }

    }

    //集合转化为数组
    public void method04(){
        Collection collection01=new ArrayList();
        collection01.add("1");
        collection01.add("2");
        collection01.add("3");

        //Object[] toArray()  将集合转化为object数组
        Object[] objs=collection01.toArray();
        for (int i = 0; i < objs.length; i++) {
            String str=(String) objs[i];
            System.out.println(str);
        }

    }

}
