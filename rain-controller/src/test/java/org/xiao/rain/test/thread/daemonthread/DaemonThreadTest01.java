package org.xiao.rain.test.thread.daemonthread;

/**
 * 守护线程。当用户线程都执行完之后。守护线程也有自动结束
 * 守护线程也叫后台线程
 * 垃圾回收器就是个守护线程
 * Author: xiaojl
 * Date: 2021/7/7 14:03
 */
public class DaemonThreadTest01 {

    public static void main(String[] args) {
        DaemonThread daemonThread = new DaemonThread();
        daemonThread.setName("守护线程");
        daemonThread.setDaemon(true);
        daemonThread.start();
        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        System.out.println(Thread.currentThread().getName() + "结束了");
    }
}

class DaemonThread extends Thread {
    @Override
    public void run() {
        int i = 0;
        while (true) {
            System.out.println(Thread.currentThread().getName() + "--->" + (++i));
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
