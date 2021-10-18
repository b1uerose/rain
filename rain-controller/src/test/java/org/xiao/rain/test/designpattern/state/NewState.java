package org.xiao.rain.test.designpattern.state;

/**
 * Author: xiaojl
 * Date: 2021/9/2 12:48
 */
public class NewState extends AbstractState {

    public NewState(ThreadContext context) {
        super(context);
        setStateName("初始状态");
    }
    
    public void start() {
        getContext().setState(new RunableState(this.getContext()));
    }
    
}
