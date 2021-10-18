package org.xiao.rain.test.designpattern.visitor;

/**
 * Author: xiaojl
 * Date: 2021/8/30 22:45
 */
public interface IElement {
    
    public void accept(IVisitor visitor);
}
