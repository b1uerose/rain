package org.xiao.rain.test.designpattern.birdge;

import org.junit.Test;

/**
 * Author: xiaojl
 * Date: 2021/8/25 22:55
 */
public class BridgeTest {
    
    @Test
    public void test() throws Exception {
        AbstractShape shape = new Triangle(new Red());
        
        shape.show();
    }
}
