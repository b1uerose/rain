package org.xiao.rain.test.designpattern.command;

import org.junit.Test;

/**
 * Author: xiaojl
 * Date: 2021/8/29 23:52
 */
public class CommandInvoker {
    
    @Test
    public void test() throws Exception {
        
        ICommand command = new ConcreteCommand(new Receiver());
        
        command.command();
    }
}
