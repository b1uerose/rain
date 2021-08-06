package org.xiao.rain.test.thread;

/**
 * 让位，让线程由运行状态改成就绪状态，还是可以立刻就获取了cpu时间片
 * Author: xiaojl
 * Date: 2021/7/6 22:39
 */
public class ThreadTest08 {

    public static void main(String[] args) {
        
        Thread thread = new Thread(new MyRunnable08());
        thread.setName("t");
        thread.start();

        for (int i = 0; i < 10001; i++) {
            System.out.println(Thread.currentThread().getName()+"---->" + i );
        }
    }
}

class MyRunnable08 implements Runnable {
    
    @Override
    public void run() {
        for (int i = 0; i < 10001; i++) {
            System.out.println(Thread.currentThread().getName()+"---->" + i );
            if(i%100==0) {
                Thread.yield();
            }
        }
    }
}
