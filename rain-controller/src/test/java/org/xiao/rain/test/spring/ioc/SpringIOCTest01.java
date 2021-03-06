package org.xiao.rain.test.spring.ioc;

import org.junit.Test;
import org.springframework.beans.factory.xml.XmlBeanDefinitionReader;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.springframework.context.support.GenericApplicationContext;
import org.xiao.rain.test.spring.ioc.beans.SpringIOCService;

/**
 * spring ioc test
 * Author: xiaojl
 * Date:2022-04-17 23:43
 */
public class SpringIOCTest01 {
    
    @Test
    public void springTest01() throws Exception {
        String configName = "newBeans.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(configName);
        SpringIOCService testService = context.getBean("springiocservice", SpringIOCService.class);
        testService.userXMLConfig();
        testService.getChild01().sayHello();
    }
    
    @Test
    public void springTest02() throws Exception {

        GenericApplicationContext context = new GenericApplicationContext();
        new XmlBeanDefinitionReader(context).loadBeanDefinitions("newBeans.xml");
        context.refresh();

        SpringIOCService springiocservice = context.getBean("springiocservice", SpringIOCService.class);
        
        springiocservice.userXMLConfig();

    }
    
}
