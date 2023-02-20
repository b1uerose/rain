package org.xiao.rain.test.spring.ioc.di.setter.collection.merge;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * 集合合并
 * Author: xiaojl
 * Date:2022-04-24 19:11
 */
public class CollectionMergeDITest {
    
    @Test
    public void colletionMerge() {

        ApplicationContext applicationContext = new ClassPathXmlApplicationContext("collectionmerge-bean.xml");

        CollectionMergeDI bean = applicationContext.getBean("child", CollectionMergeDI.class);
        CollectionMergeDI parent1 = applicationContext.getBean("parent", CollectionMergeDI.class);

        System.out.println( parent1.getMap());

        System.out.println(bean.getMap());
        
        
    }
}
