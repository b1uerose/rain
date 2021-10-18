package org.xiao.rain.test.designpattern.state;

/**
 * 抽象状态类
 * Author: xiaojl
 * Date: 2021/9/2 12:44
 */
public class AbstractState {
    
    public AbstractState(ThreadContext context) {
        this.context = context;
    }
    
    private String stateName;
    private ThreadContext context;

    public ThreadContext getContext() {
        return context;
    }

    public void setContext(ThreadContext context) {
        this.context = context;
    }

    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Override
    public String toString() {
        return "进入" + this.stateName +" ";
    }
}
