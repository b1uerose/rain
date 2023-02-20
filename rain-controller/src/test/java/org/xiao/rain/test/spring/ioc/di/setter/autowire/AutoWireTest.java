package org.xiao.rain.test.spring.ioc.di.setter.autowire;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: xiaojl
 * Date:2022-04-26 22:51
 */
public class AutoWireTest {
    
    @Test
    public void autoWire() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-autowire.xml");

        Student student = applicationContext.getBean("student", Student.class);

        System.out.println(student);

    }
}
