package org.xiao.rain.test.spring.ioc.beans.factory;

/**
 * spring factory-bean
 * Author: xiaojl
 * Date:2022-04-21 21:57
 */
public class SpringBeanFactory {
    
//    private static FactoryBean1 bean1 = new FactoryBean1();
    
    public IFactoryBean getFactoryBean() {
        IFactoryBean bean = new FactoryBean1();
        System.out.println("实例工厂方法创建的bean：" + bean);
        return bean;
    }
    
    public static IFactoryBean staitcFactoryMethod() {
        IFactoryBean bean = new FactoryBean1();
        System.out.println("静态工厂方法创建的bean：" + bean);
        return bean;
    }
    
    static class FactoryBean1 implements IFactoryBean {
        
        
    }
}
