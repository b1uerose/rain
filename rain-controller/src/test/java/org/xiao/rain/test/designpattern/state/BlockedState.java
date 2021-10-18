package org.xiao.rain.test.designpattern.state;

/**
 * Author: xiaojl
 * Date: 2021/9/2 18:43
 */
public class BlockedState extends AbstractState {

    public BlockedState(ThreadContext context) {
        super(context);
        setStateName("阻塞状态");
    }
    
    public void resume() {
        getContext().setState(new RunableState(getContext()));
    }
    
}
