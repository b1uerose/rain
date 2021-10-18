package org.xiao.rain.test.designpattern.mediator;

/**
 * Author: xiaojl
 * Date: 2021/9/1 12:45
 */
public class Mediator extends AbstractMediator{

    public void register(AbstractColleague colleague) {
        this.colleagues.add(colleague);
        colleague.setMediator(this);
    }

    public void relay(AbstractColleague colleague) {
        for (AbstractColleague col : colleagues) {
            if(!colleague.equals(col)) {
                col.receive();
            }
        }
    }
    
}
