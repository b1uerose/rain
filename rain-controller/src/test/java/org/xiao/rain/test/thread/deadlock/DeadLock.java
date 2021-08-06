package org.xiao.rain.test.thread.deadlock;

/**
 * 死锁
 * 不要嵌套写synchronize代码块
 * Author: xiaojl
 * Date: 2021/7/7 12:43
 */
public class DeadLock {

    public static void main(String[] args) {
        Object obj1 = new Object();
        Object obj2 = new Object();

        DeadLockThread1 deadLockThread1 = new DeadLockThread1(obj1, obj2);
        DeadLockThread2 deadLockThread2 = new DeadLockThread2(obj1, obj2);
        deadLockThread1.start();
        deadLockThread2.start();

    }
}

class DeadLockThread1 extends Thread {
    private Object obj1;
    private Object obj2;

    public DeadLockThread1(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        synchronized (obj1) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            synchronized (obj2) {
                
            }
        }
    }
}

class DeadLockThread2 extends Thread {
    private Object obj1;
    private Object obj2;

    public DeadLockThread2(Object obj1, Object obj2) {
        this.obj1 = obj1;
        this.obj2 = obj2;
    }

    @Override
    public void run() {
        synchronized (obj2) {
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
            }
            synchronized (obj1) {

            }
        }
    }
}
