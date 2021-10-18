package org.xiao.rain.test.thread;

/**
 * 保护性演示
 * Author: xiaojl
 * Date: 2021/9/20 21:55
 */
public class GuardedSuspension {
    
    private Object response;
    public Object get() {
        while (response == null) {
            synchronized (this) {
                try {
                    this.wait();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
        return response;
    }
    
    public void set(Object object) {
        synchronized (this) {
            this.response = object;
            this.notifyAll();
        }
    }

    public static void main(String[] args) {
        GuardedSuspension gs = new GuardedSuspension();
        Thread t1 = new Thread(() -> {
            Object o = gs.get();
        }, "t1");
        t1.start();
        
        Thread t2 = new Thread(() -> {
            gs.set(new Object());
        }, "t2");
        t2.start();
    }
}
