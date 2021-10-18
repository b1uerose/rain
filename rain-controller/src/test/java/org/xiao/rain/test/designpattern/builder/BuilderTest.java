package org.xiao.rain.test.designpattern.builder;

import org.junit.Test;

/**
 * Author: xiaojl
 * Date: 2021/8/23 13:40
 */
public class BuilderTest {
    
    @Test
    public void testBuilder() {
        
        IBuilder builder = new Builder();
        
        Director director = new Director(builder);
        
        Product product = director.constructProduct();
    }
}
