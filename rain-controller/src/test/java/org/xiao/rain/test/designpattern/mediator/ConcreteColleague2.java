package org.xiao.rain.test.designpattern.mediator;

/**
 * Author: xiaojl
 * Date: 2021/9/1 12:39
 */
public class ConcreteColleague2 extends AbstractColleague {
    @Override
    public void receive() {
        System.out.println(this.getClass().getSimpleName() + "收到了消息");
    }

    @Override
    public void send() {
        getMediator().relay(this);
    }
}
