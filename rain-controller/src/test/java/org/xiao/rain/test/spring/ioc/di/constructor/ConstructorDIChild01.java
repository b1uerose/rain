package org.xiao.rain.test.spring.ioc.di.constructor;

public class ConstructorDIChild01 {
    public void say() {
        System.out.println("是个孩子：" + this.getClass().getName());
    }
}