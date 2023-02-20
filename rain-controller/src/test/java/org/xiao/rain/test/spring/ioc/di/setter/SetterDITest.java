package org.xiao.rain.test.spring.ioc.di.setter;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: xiaojl
 * Date:2022-04-23 23:36
 */
public class SetterDITest {
    
    @Test
    public void setterDITest01() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("setterDI.xml");
        SetterDIBean setterBean = applicationContext.getBean("setterBean", SetterDIBean.class);
        System.out.println(setterBean);
    }
    
    @Test
    public void pNameSpaceTest() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("setterDI.xml");
        SetterDIBean p_namespace = applicationContext.getBean("p_namespace", SetterDIBean.class);
        System.out.println(p_namespace);
    }
}
