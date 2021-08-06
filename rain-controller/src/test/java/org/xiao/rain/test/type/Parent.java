package org.xiao.rain.test.type;

/**
 * Author: xiaojl
 * Date: 2021/6/26 15:54
 */
public class Parent extends Human {
    
    {
        System.out.println("2、父类被初始化了");
    }
    
    static {
        System.out.println("父类被加载了");
    }
    
    public void doSome() {
        System.out.println("做些事情把");
    }
    
    public Parent() {
        System.out.println("父类的默认构造函数被调用了");
    }
    
    public Parent(int id, String name) {
        System.out.println("父类的带参数的构造函数被调用了");
    }
}
