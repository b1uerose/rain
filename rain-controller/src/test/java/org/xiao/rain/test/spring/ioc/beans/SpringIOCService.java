package org.xiao.rain.test.spring.ioc.beans;

/**
 * 测试spring ioc工具类
 * Author: xiaojl
 * Date:2022-04-17 23:48
 */
public class SpringIOCService {
    
    private SpringIOCChild01 child01;
    private SpringIOCChild02 child02;
    
    public void userXMLConfig() {
        System.out.println("用xml来配置bean");
    }
}
