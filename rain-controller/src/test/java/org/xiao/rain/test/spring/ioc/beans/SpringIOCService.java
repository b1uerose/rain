package org.xiao.rain.test.spring.ioc.beans;

/**
 * 测试spring ioc工具类
 * Author: xiaojl
 * Date:2022-04-17 23:48
 */
public class SpringIOCService {
    
    public SpringIOCService() {
        System.out.println("creating SpringIOCService......");
    }
    
    private SpringIOCChild01 child01;
    private SpringIOCChild02 child02;

    public SpringIOCChild01 getChild01() {
        return child01;
    }

    public void setChild01(SpringIOCChild01 child01) {
        this.child01 = child01;
    }

    public SpringIOCChild02 getChild02() {
        return child02;
    }

    public void setChild02(SpringIOCChild02 child02) {
        this.child02 = child02;
    }

    public void userXMLConfig() {
        System.out.println("用xml来配置bean");
    }
}
