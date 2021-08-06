package org.xiao.rain.test.thread;

/**
 * 设置线程优先级 优先级高的获得的cpu时间片多一些
 * 默认5 最高10 最低1
 * Author: xiaojl
 * Date: 2021/7/6 22:34
 */
public class ThreadTest07 {
    public static void main(String[] args) {
        System.out.println("线程的最高优先级:" + Thread.MAX_PRIORITY);
        System.out.println("线程的最低优先级:" + Thread.MIN_PRIORITY);
        System.out.println("线程的默认优先级:" + Thread.NORM_PRIORITY);
        Thread.currentThread().setPriority(Thread.MAX_PRIORITY);
        
        Thread thread = new Thread(new MyRunnable07());
        thread.setName("t");
        thread.setPriority(Thread.MIN_PRIORITY);
        thread.start();
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() +"--->" + i);
        }
    }
}

class MyRunnable07 implements Runnable {

    @Override
    public void run() {
        for (int i = 0; i <= 100; i++) {
            System.out.println(Thread.currentThread().getName() +"--->" + i);
        }
    }
}
