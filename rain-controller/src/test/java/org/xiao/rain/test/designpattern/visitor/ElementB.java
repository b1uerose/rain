package org.xiao.rain.test.designpattern.visitor;

/**
 * Author: xiaojl
 * Date: 2021/8/30 22:47
 */
public class ElementB implements IElement {
    @Override
    public void accept(IVisitor visitor) {
        visitor.visit(this);
    }
    
    public void operator() {
        System.out.println("元素b被访问");
    }
}
