package org.xiao.rain.test.designpattern.command;

/**
 *  
 * Author: xiaojl
 * Date: 2021/8/29 23:43
 */
public abstract class Command implements ICommand {
    
    protected Receiver receiver;
    
    public Command(Receiver receiver) {
        this.receiver = receiver;
    }
    
}
