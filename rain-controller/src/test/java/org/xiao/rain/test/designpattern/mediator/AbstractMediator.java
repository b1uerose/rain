package org.xiao.rain.test.designpattern.mediator;

import java.util.ArrayList;
import java.util.List;

/**
 * 抽象中介者
 * Author: xiaojl
 * Date: 2021/9/1 12:25
 */
public abstract class AbstractMediator {
    
    protected List<AbstractColleague> colleagues = new ArrayList<>();
    
    public abstract void register(AbstractColleague colleague);
    
    public abstract void relay(AbstractColleague colleague);
    
}
