package org.xiao.rain.test.designpattern.visitor;

/**
 * Author: xiaojl
 * Date: 2021/8/30 22:46
 */
public interface IVisitor {
    
    public void visit(ElementA element);
    public void visit(ElementB element);
}
