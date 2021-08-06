package org.xiao.rain.test.thread;

/**
 * 设置和获取线程名称，获取当前线程Thread.currentThread();
 * Author: xiaojl
 * Date: 2021/7/6 12:38
 */
public class ThreadTest03 {

    public static void main(String[] args) {

        Thread thread = Thread.currentThread();
        System.out.println("主线程名字：" + thread.getName());

        MyThread2 myThread2 = new MyThread2();
        myThread2.setName("线程1");

        MyThread2 myThread3 = new MyThread2();
        myThread3.setName("线程2");
        
        myThread2.start();
        myThread3.start();

    }
}

class MyThread2 extends Thread {
    @Override
    public void run() {
        Thread currentThread = Thread.currentThread();
        for (int i = 0; i < 100; i++) {
            System.out.println("[" + currentThread.getName() +"]:" + i);
        }
    }
}
