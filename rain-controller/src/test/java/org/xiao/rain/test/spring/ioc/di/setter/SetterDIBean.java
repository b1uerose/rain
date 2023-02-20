package org.xiao.rain.test.spring.ioc.di.setter;

/**
 * setter注入
 * Author: xiaojl
 * Date:2022-04-23 23:18
 */
public class SetterDIBean {
    
    private int age;
    private String name;
    private OtherInfo info;

    public void setAge(int age) {
        this.age = age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setInfo(OtherInfo info) {
        this.info = info;
    }

    @Override
    public String toString() {
        return "SetterDIBean{" +
                "age=" + age +
                ", name='" + name + '\'' +
                ", info=" + info +
                '}';
    }
}

class OtherInfo {
    @Override
    public String toString() {
        return "信息啦啦啦";
    }
}