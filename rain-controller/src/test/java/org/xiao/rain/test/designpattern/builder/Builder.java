package org.xiao.rain.test.designpattern.builder;

/**
 * Author: xiaojl
 * Date: 2021/8/23 09:54
 */
public class Builder extends AbstractBuilder {

    @Override
    public void buildPartA() {
        System.out.println("设置属性1");
        m_product.setAttr1("设置属性1");
    }

    @Override
    public void buildPartB() {
        System.out.println("设置属性2");
        m_product.setAttr1("设置属性2");
    }

    @Override
    public void buildPartC() {
        System.out.println("设置属性3");
        m_product.setAttr1("设置属性3");
    }
}
