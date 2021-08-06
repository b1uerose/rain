package org.xiao.rain.test.type;

/**
 * Author: xiaojl
 * Date: 2021/6/26 22:28
 */
public abstract class Human {
    
    {
        System.out.println("1、人类被实例化");
    }
    
    static {
        System.out.println("人类被加载了");
    }

    public Human() {
        System.out.println("人类构造函数被调用");
    }
}
