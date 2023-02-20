package org.xiao.rain.test.spring.ioc.di.methodinjection;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: xiaojl
 * Date:2022-04-25 19:16
 */
public class MethodInjectionTest {
    
   @Test 
    public void test() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("method-injection.xml");
        
        MethodInjectionSingleton singleton = applicationContext.getBean("misingleton", MethodInjectionSingleton.class);

        singleton.say();
        singleton.say();
        singleton.say();
        singleton.say();
        
        
    }
}
