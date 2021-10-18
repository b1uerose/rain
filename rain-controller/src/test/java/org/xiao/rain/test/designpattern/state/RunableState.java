package org.xiao.rain.test.designpattern.state;

/**
 * Author: xiaojl
 * Date: 2021/9/2 18:42
 */
public class RunableState extends AbstractState {

    public RunableState(ThreadContext context) {
        super(context);
        setStateName("可运行状态");
    }
    
    public void getCpu() {
        getContext().setState(new RunningState(getContext()));
    }
}
