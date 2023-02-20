package org.xiao.rain.test.spring.ioc.di.constructor;

/**
 * 构造函数注入 使用index或者name
 * Author: xiaojl
 * Date:2022-04-22 15:57
 */
public class ConstructorDIParent2 {
    String name;
    int age;
    public ConstructorDIParent2(String name, int age) {
        this.name = name;
        this.age = age;
    }
    
    public void say() {
        System.out.println(name +" is " + age + " years old");
    }
}



