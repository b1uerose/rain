package org.xiao.rain.test.designpattern.state;

/**
 * 运行状态
 * Author: xiaojl
 * Date: 2021/9/2 18:42
 */
public class RunningState extends AbstractState{
    
    public RunningState(ThreadContext context) {
        super(context);
        setStateName("运行状态");
    }
    
    public void suspend() {
        getContext().setState(new BlockedState(getContext()));
    }
    
    public void end() {
        getContext().setState(new DeadState(getContext()));
    }
    
}
