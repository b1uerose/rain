package org.xiao.rain.test.designpattern.visitor;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: xiaojl
 * Date: 2021/8/30 22:51
 */
public class VisitorPatternStructure {
    
    private List<IElement> elements = new ArrayList<>();
    
    public void addElement(IElement element) {
        elements.add(element);
    }
    
    public void visit(IVisitor visitor) {
        for (IElement element : elements) {
            element.accept(visitor);
        }
    }
}
