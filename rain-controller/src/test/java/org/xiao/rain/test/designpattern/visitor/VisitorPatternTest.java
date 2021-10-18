package org.xiao.rain.test.designpattern.visitor;

import org.junit.Test;

/**
 * Author: xiaojl
 * Date: 2021/8/30 22:58
 */
public class VisitorPatternTest {
    
    @Test
    public void test() throws Exception {
        ElementA elementA = new ElementA();
        ElementB elementB = new ElementB();
        
        VisitorPatternStructure pattern = new VisitorPatternStructure();
        pattern.addElement(elementA);
        pattern.addElement(elementB);
        
        pattern.visit(new VisitorA());
        System.out.println("======================");
        pattern.visit(new VisitorB());
        
    }
    
    
}
