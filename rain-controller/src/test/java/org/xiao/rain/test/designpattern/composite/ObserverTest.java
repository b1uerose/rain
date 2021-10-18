package org.xiao.rain.test.designpattern.composite;

import org.junit.Test;

/**
 * Author: xiaojl
 * Date: 2021/8/31 23:33
 */
public class ObserverTest {
    
    @Test
    public void test() throws Exception {

        OilFurtures subject = new OilFurtures();
        subject.addObserver(new BullObserver());
        subject.addObserver(new BearObserver());
        
        subject.setPrice(10);

        System.out.println("=================");
        
        subject.setPrice(-10);
        
        
    }
}
