package org.xiao.rain.test.spring.ioc.di.setter.autowire.bytype;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: xiaojl
 * Date:2022-04-26 23:02
 */
public class AutoWireByTypeTest {
    
    @Test
    public void autoWireTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("bean-autowire-bytype.xml");
        Student student = applicationContext.getBean("student", Student.class);
        System.out.println(student);
    }
}
