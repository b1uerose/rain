package org.xiao.rain.test.spring.ioc.di.setter.autowire.bytype;

/**
 * 自动注入
 * Author: xiaojl
 * Date:2022-04-26 22:44
 */
public class School3 implements ISchool {
    
    private String name;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return name;
    }
}
