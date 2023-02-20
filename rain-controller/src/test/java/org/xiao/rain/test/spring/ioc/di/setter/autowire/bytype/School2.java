package org.xiao.rain.test.spring.ioc.di.setter.autowire.bytype;

/**
 * 自动注入
 * Author: xiaojl
 * Date:2022-04-26 22:44
 */
public class School2 extends School {
    
    private String location;

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "School2{" +
                "location='" + location + '\'' +
                "name='" + getName() + '\'' +
                '}';
    }
}
