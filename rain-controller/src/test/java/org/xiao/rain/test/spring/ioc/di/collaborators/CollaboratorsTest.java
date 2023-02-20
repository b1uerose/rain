package org.xiao.rain.test.spring.ioc.di.collaborators;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

/**
 * Author: xiaojl
 * Date:2022-04-24 00:20
 */
public class CollaboratorsTest {
    
    @Test
    public void collaboratorsTest() {

        ApplicationContext parent = new ClassPathXmlApplicationContext("collaborators-parent.xml");
        
        ApplicationContext child = new ClassPathXmlApplicationContext(new String[] {"collaborators-child.xml"}, parent);


        CollaboratorsChild childBean = child.getBean("child", CollaboratorsChild.class);



        System.out.println(childBean);

    }
}
