package org.xiao.rain.test.spring.ioc.di.annotation.component;

import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

/**
 * Author: xiaojl
 * Date:2022-04-27 22:40
 */
@Component("student")
public class StudentWithAnnotation {
    
    @Value("${name}")
    private String name;
    @Value("${age}")
    private int age;
    
    @Autowired(required = false)
//    @Qualifier("rm-1") byName的方式指定bean
    private School school;
    
    @Resource(name = "xiaoxue")
    //默认是byname的方式。如果没有找到就用bytype的方式自动注入
    private PrimarySchool primarySchool;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

//    @Value("20")
    public void setAge(int age) {
        this.age = age;
    }

    @Override
    public String toString() {
        return "StudentWithAnnotation{" +
                "name='" + name + '\'' +
                ", age=" + age +
                ", school=" + school +
                ", primarySchool=" + primarySchool +
                '}';
    }
}

@Component("xiaoxue")
class PrimarySchool {
    @Value("上海小学")
    private String name;
    @Value("上海市")
    private String location;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getLocation() {
        return location;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    @Override
    public String toString() {
        return "PrimarySchool{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }
}

@Component("mySchool")
class School {
    
    @Value("北京大学")
    private String name;
    @Value("北京市")
    private String location;

    @Override
    public String toString() {
        return "School{" +
                "name='" + name + '\'' +
                ", location='" + location + '\'' +
                '}';
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setLocation(String location) {
        this.location = location;
    }
}
