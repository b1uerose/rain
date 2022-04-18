package org.xiao.rain.test.spring.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
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
        SpringIOCService testService = (SpringIOCService) context.getBean("springioc");
        testService.userXMLConfig();
    }
}
