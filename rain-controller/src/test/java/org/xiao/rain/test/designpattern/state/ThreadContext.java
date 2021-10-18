package org.xiao.rain.test.designpattern.state;

/**
 * 线程状态上下文
 * Author: xiaojl
 * Date: 2021/9/2 12:45
 */
public class ThreadContext {

    private AbstractState state;

    public AbstractState getState() {
        return state;
    }

    public void setState(AbstractState state) {
        System.out.println(state);
        this.state = state;
    }

    public ThreadContext() {
        setState(new NewState(this));
    }

    public void start() {
        ((NewState) state).start();
    }

    public void getCpu() {
        ((RunableState) state).getCpu();
    }

    public void suspend() {
        ((RunningState) state).suspend();
    }

    public void resume() {
        ((BlockedState) state).resume();
    }

    public void end() {
        ((RunningState)state).end();
    }
}
