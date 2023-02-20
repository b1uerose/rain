package org.xiao.rain.test.spring.ioc.di.setter.autowire.bytype;

/**
 * 自动注入
 * Author: xiaojl
 * Date:2022-04-26 22:45
 */
public class Student {
    
    private String name;
    private int age;
    private ISchool school;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public ISchool getSchool() {
        return school;
    }

    public void setSchool(ISchool school) {
        this.school = school;
    }

    @Override
    public String toString() {
        return "Student{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                '}';
    }
}
