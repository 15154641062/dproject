package com.bh.myspring.test;

import com.bh.myspring.pojo.User;
import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanFactory;
import org.springframework.core.io.ClassPathResource;


public class BeanTest {
    @Test
    public void beanTest(){
        XmlBeanFactory banFactory=new XmlBeanFactory(new ClassPathResource("Beans.xml"));
        User user= (User) banFactory.getBean("User");
        System.out.println(user);
    }

    @Test
    public void scopeTest(){
        XmlBeanFactory banFactory=new XmlBeanFactory(new ClassPathResource("Beans.xml"));
        User user1= (User) banFactory.getBean("User");
        System.out.println(user1);
        user1.setName("李四");

        User user2= (User) banFactory.getBean("User");
        System.out.println(user2);
    }
}