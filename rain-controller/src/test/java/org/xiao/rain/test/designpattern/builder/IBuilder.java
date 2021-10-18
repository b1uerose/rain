package org.xiao.rain.test.designpattern.builder;

/**
 * 建造者接口
 * Author: xiaojl
 * Date: 2021/8/23 09:49
 */
public interface IBuilder {

    /**
     * 建造第一部分
     */
    public void buildPartA();

    /**
     * 建造第二部分
     */
    public void buildPartB();

    /**
     * 建造第三部分
     */
    public void buildPartC();
    
    public Product createProduct();
}
