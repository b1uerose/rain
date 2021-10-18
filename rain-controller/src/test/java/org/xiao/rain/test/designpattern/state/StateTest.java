package org.xiao.rain.test.designpattern.state;

import org.junit.Test;

/**
 * Author: xiaojl
 * Date: 2021/9/2 12:43
 */
public class StateTest {
    
    @Test
    public void test() throws Exception {
        ThreadContext context = new ThreadContext();
        context.start();
        context.getCpu();
        context.suspend();
        context.resume();
        context.getCpu();
        context.end();
    }
}
