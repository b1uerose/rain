package org.xiao.rain.test.spring.ioc;

import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;
import org.xiao.rain.service.impl.RainQueryServiceImpl;
import org.xiao.rain.service.itf.IRainQueryService;

/**
 * Author: xiaojl
 * Date: 2021/7/23 23:12
 */
public class SpringTest01 {
    
//    @Test
    public void test01() throws Exception {
        String retMsg = new RainQueryServiceImpl().doSome();
        System.out.println(retMsg);
    }
    
//    @Test
    public void test02() throws Exception {
        //1、指定spring的路径
        String path = "beans.xml";
        //2、创建spring容器，applicationcontext
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        //3、通过容器去获取bean
        IRainQueryService service = (IRainQueryService) context.getBean("rainQueryService");
        String retMsg = service.doSome();
        System.out.println(retMsg);
    }
    
//    @Test
    public void test03() throws Exception {
        String path = "beans.xml";
        ApplicationContext context = new ClassPathXmlApplicationContext(path);
        //获取容器中对象的数量
        int nums = context.getBeanDefinitionCount();
        System.out.println("容器中有：" + nums + "个对象");
        //获取容器中所有对象的名称
        String[] beanNames = context.getBeanDefinitionNames();
        for (String beanName : beanNames) {
            System.out.println(beanName);
        }
        //判断是否是个单例
        Object obj1 = context.getBean("rainQueryService");
        Object obj2 = context.getBean("rainQueryService2");
        Object obj4 = context.getBean("rainQueryService2");
        Object obj3 = context.getBean("rainQueryService");
        System.out.println(obj1 == obj3);
        System.out.println(obj1 == obj2);
        System.out.println(obj4 == obj2);

    }
}
