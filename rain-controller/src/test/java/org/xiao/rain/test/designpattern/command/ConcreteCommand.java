package org.xiao.rain.test.designpattern.command;

/**
 * Author: xiaojl
 * Date: 2021/8/29 23:45
 */
public class ConcreteCommand extends Command {

    public ConcreteCommand(Receiver receiver) {
        super(receiver);
    }

    @Override
    public void command() {
        receiver.action();
    }

    @Override
    public void undo() {
        receiver.undo();
    }
}
