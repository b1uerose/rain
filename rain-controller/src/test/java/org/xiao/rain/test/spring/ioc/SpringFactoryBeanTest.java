package org.xiao.rain.test.spring.ioc;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * spring 工厂配置
 * Author: xiaojl
 * Date:2022-04-21 22:20
 */
public class SpringFactoryBeanTest {
    
    @Test
    public void testFactoryBean() {

//        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("factoryBeans.xml", "staticFactoryBean.xml");
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("staticFactoryBean.xml");
        ClassPathXmlApplicationContext beanFactory = new ClassPathXmlApplicationContext("staticFactoryBean.xml");

        //可以创建多个容器

        Class<?> type = beanFactory.getType("staticFactoryMethodBean");
        System.out.println(type.getSimpleName());
//        IFactoryBean bean = applicationContext.getBean("staticFactoryMethodBean", IFactoryBean.class);
//
//        System.out.println(bean);
//
//        IFactoryBean bean2 = applicationContext.getBean("staticFactoryMethodBean", IFactoryBean.class);
//        System.out.println(bean2);
        
    }
    
    
}
