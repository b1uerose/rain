package org.xiao.rain.test.spring.ioc.beaninit;

/**
 * bean 的init和destory 测试
 * Author: xiaojl
 * Date:2022-04-28 19:45
 */
public class InitBean {
    
    public String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
    
    public void init() {
        System.out.println("初始化bean");
    }
    
    public void destroy() {
        System.out.println("销毁bean");
    }
}
