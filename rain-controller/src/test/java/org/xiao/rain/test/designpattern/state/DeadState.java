package org.xiao.rain.test.designpattern.state;

/**
 * Author: xiaojl
 * Date: 2021/9/2 18:43
 */
public class DeadState extends AbstractState {

    public DeadState(ThreadContext context) {
        super(context);
        setStateName("死亡状态");
    }
    
}
