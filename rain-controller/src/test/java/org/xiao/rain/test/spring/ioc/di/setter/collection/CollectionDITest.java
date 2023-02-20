package org.xiao.rain.test.spring.ioc.di.setter.collection;

import java.util.Properties;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 集合类的注入
 * Author: xiaojl
 * Date:2022-04-24 10:53
 */
public class CollectionDITest {

    @Test
    public void collectionDITest01() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("collection-bean.xml");

        CollectionsDI collections = applicationContext.getBean("collections", CollectionsDI.class);

        Properties properties = collections.getProperties();


        System.out.println(properties);

    }
}
