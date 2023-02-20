package org.xiao.rain.test.spring.ioc.di.annotation.component;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 使用注解
 * Author: xiaojl
 * Date:2022-04-27 22:41
 */
public class ComponentAnnotationTest {
    
    @Test
    public void componentAnnotationTest() {
        String containerXml = "annotation/applicationContext.xml";
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext(containerXml);
        StudentWithAnnotation student = applicationContext.getBean("student", StudentWithAnnotation.class);
        System.out.println(student);
    }
}
