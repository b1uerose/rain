package org.xiao.rain.test.designpattern.builder;

/**
 * Author: xiaojl
 * Date: 2021/8/23 09:55
 */
public class Director {

    public IBuilder m_builder;

    public Director(IBuilder builder) {
        this.m_builder = builder;
    }

    public Product constructProduct() {
        m_builder.buildPartA();
        m_builder.buildPartB();
        m_builder.buildPartC();
        Product product = m_builder.createProduct();
        System.out.println(product);
        return product;
    }
}
