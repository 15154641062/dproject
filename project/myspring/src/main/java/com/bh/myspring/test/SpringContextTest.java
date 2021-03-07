package com.bh.myspring.test;

import com.bh.myspring.entity.Vehicle;
import com.bh.myspring.pojo.User;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.support.AbstractApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.test.context.ActiveProfiles;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


//@ActiveProfiles({"test"})
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations = {"classpath:applicationContext.xml"})
public class SpringContextTest {
    @Autowired
    @Qualifier("User2")
    private User user;

//    @Autowired
//    private Vehicle vehicle;

    @Test
    public void annotationTest() {
        AbstractApplicationContext applicationContext = new ClassPathXmlApplicationContext("applicationContext.xml");
        Vehicle vehicle = (Vehicle) applicationContext.getBean("Vehicle");

        vehicle.toSay();
        //applicationContext.registerShutdownHook();

//        AbstractApplicationContext applicationContext= new ClassPathXmlApplicationContext("applicationContext.xml");
//        Animal animal= (Animal) applicationContext.getBean("Animal");
//        animal.toSay();
    }


    @Test
    public void springContextTest() {
//        AbstractApplicationContext applicationContext= new ClassPathXmlApplicationContext("applicationContext.xml");
//        User user= (User) applicationContext.getBean("User");

        System.out.println(user);
        //applicationContext.registerShutdownHook();

//        AbstractApplicationContext applicationContext= new ClassPathXmlApplicationContext("applicationContext.xml");
//        Animal animal= (Animal) applicationContext.getBean("Animal");
//        animal.toSay();
    }
}
