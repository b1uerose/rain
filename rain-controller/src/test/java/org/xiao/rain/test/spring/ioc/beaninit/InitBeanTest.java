package org.xiao.rain.test.spring.ioc.beaninit;

import org.junit.Test;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: xiaojl
 * Date:2022-04-28 19:48
 */
public class InitBeanTest {
    
    @Test
    public void test() {
        System.out.println("1、创建容器");
        ClassPathXmlApplicationContext applicationContext = new ClassPathXmlApplicationContext("beaninit/beanInit.xml");
        System.out.println("2、获取bean");
        InitBean init = applicationContext.getBean("initbean", InitBean.class);
        InitBean2 init2 = applicationContext.getBean("initBean2", InitBean2.class);
        System.out.println(init2);
        applicationContext.close();
    }
    
    @Test
    public void dependentTest() {
       ClassPathXmlApplicationContext context = new ClassPathXmlApplicationContext("beaninit/beanInit.xml");

        DependentBean dependentBean = context.getBean(DependentBean.class);
        DependencyBean dependencyBean = context.getBean(DependencyBean.class);

        System.out.println(dependentBean);
        System.out.println(dependencyBean);
    }
}
