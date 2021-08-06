package org.xiao.rain.test.thread;

/**
 * 合并线程 thread.join();让当前线程注释，只是thread结束
 * Author: xiaojl
 * Date: 2021/7/6 22:43
 */
public class ThreadTest09 {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyRunnable09());
        thread.setName("t");
        thread.start();

        try {
            thread.join();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println("主线程执行完毕");
    }
    
}

class MyRunnable09 implements Runnable {
    
    @Override
    public void run() {
        for (int i = 0; i < 100; i++) {
            System.out.println(Thread.currentThread().getName() + "---->" + i);
        }
    }
}

