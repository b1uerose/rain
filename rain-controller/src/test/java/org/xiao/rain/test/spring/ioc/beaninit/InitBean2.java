package org.xiao.rain.test.spring.ioc.beaninit;

import java.io.Closeable;
import java.io.IOException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.ApplicationContext;
import org.springframework.stereotype.Component;

/**
 * bean 的init和destory 测试
 * Author: xiaojl
 * Date:2022-04-28 19:45
 */
@Component
public class InitBean2 implements Closeable, AutoCloseable {
    
    @Value("xxxx")
    public String name;

    public String getName() {
        return name;
    }
    
    @Autowired
    public ApplicationContext context;

    public void setName(String name) {
        this.name = name;
    }

    @Override
    public String toString() {
        return "InitBean2{" +
                "name='" + name + '\'' +
                ", context=" + context +
                '}';
    }

    @Override
    public void close() throws IOException {
        System.out.println("推测关闭方法");
    }
}
