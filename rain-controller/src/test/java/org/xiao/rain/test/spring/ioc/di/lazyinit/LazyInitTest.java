package org.xiao.rain.test.spring.ioc.di.lazyinit;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: xiaojl
 * Date:2022-04-24 23:15
 */
public class LazyInitTest {
   
    @Test
    public void test() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("LazyInit.xml");

        System.out.println("容器创建完成");
        LazyInit lazy = applicationContext.getBean("lazy", LazyInit.class);
        
    }
    
    
}
