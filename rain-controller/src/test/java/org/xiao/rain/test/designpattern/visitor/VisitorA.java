package org.xiao.rain.test.designpattern.visitor;

/**
 * Author: xiaojl
 * Date: 2021/8/30 22:49
 */
public class VisitorA implements IVisitor{
    @Override
    public void visit(ElementA element) {
        element.operator();
    }

    @Override
    public void visit(ElementB element) {
        element.operator();
    }
}
