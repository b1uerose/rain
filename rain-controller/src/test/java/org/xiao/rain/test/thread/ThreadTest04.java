package org.xiao.rain.test.thread;

/**
 * 中断线程的sleep interrupt();
 * 会有interruptexception 需要处理
 * Author: xiaojl
 * Date: 2021/7/6 13:28
 */
public class ThreadTest04 {
    public static void main(String[] args) {

        Thread thread = new Thread(new InterruptThread());
        thread.start();
        try {
            Thread.sleep(1000 * 1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(thread.isInterrupted());
        if(!thread.isInterrupted()) {
            thread.interrupt();
        }
        System.out.println("helloWorld");
    }
}

class InterruptThread implements Runnable {
    @Override
    public void run() {

        try {
            Thread.sleep(1000 * 60 * 60 * 24 * 365);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println("线程被中止睡眠了");
    }
}
