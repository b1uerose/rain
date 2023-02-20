package org.xiao.rain.test.spring.ioc.di.constructor;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 构造函数注入
 * Author: xiaojl
 * Date:2022-04-22 16:14
 */
public class ConstructorDITest {
    
    @Test
    public void constructorDITest01() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("constructorDI.xml");
        ConstructorDIParent parent = applicationContext.getBean("parent", ConstructorDIParent.class);
        ConstructorDIParent parent1 = applicationContext.getBean("parent", ConstructorDIParent.class);

        parent.getChild01().say();
        parent.getChild02().say();
        parent1.getChild01().say();
        parent1.getChild02().say();

        System.out.println(parent);
    }
    
//    @Test
    public void constructorDITest02() {
        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("constructorDI.xml");

        ConstructorDIParent2 xiaojl = applicationContext.getBean("xiaojl", ConstructorDIParent2.class);
        ConstructorDIParent2 sunl = applicationContext.getBean("sunl", ConstructorDIParent2.class);
        ConstructorDIParent2 xiaoyu = applicationContext.getBean("xiaoyu", ConstructorDIParent2.class);

        xiaojl.say();
        sunl.say();
        xiaoyu.say();
    }
    
    
}
