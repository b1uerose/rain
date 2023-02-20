package org.xiao.rain.test.spring.ioc.di.constructor;

/**
 * 构造函数注入
 * Author: xiaojl
 * Date:2022-04-22 15:57
 */
public class ConstructorDIParent {
    ConstructorDIChild01 child01;
    ConstructorDIChild02 child02;
//    @ConstructorProperties({"child01", "child02"})
    public ConstructorDIParent(ConstructorDIChild01 child01, ConstructorDIChild02 child02) {
        this.child01 = child01;
        this.child02 = child02;
    }

    public ConstructorDIChild01 getChild01() {
        return child01;
    }

    public ConstructorDIChild02 getChild02() {
        return child02;
    }
}



