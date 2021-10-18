package org.xiao.rain.test.designpattern.mediator;

/**
 * Author: xiaojl
 * Date: 2021/9/1 12:32
 */
public abstract class AbstractColleague {
    
    private AbstractMediator mediator;

    public void setMediator(AbstractMediator mediator) {
        this.mediator = mediator;
    }

    public AbstractMediator getMediator() {
        return mediator;
    }

    public abstract void receive();
    
    public abstract void send();
    
}
