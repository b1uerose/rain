package org.xiao.rain.test.designpattern.builder;

/**
 * Author: xiaojl
 * Date: 2021/8/23 09:51
 */
public abstract class AbstractBuilder implements IBuilder {
    
    protected Product m_product = new Product();

    @Override
    public abstract void buildPartA();

    @Override
    public abstract void buildPartB();

    @Override
    public abstract void buildPartC();
    
    public Product createProduct() {
        return m_product;
    }
}
