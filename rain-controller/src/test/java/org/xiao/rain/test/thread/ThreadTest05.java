package org.xiao.rain.test.thread;

/**
 * 强行中止线程，会导致丢失数据，不建议使用
 * Author: xiaojl
 * Date: 2021/7/6 19:37
 */
public class ThreadTest05 {
    public static void main(String[] args) {
        Thread thread = new Thread(new MyThread5());
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
//        thread.stop();
    }
}

class MyThread5 implements Runnable {
    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            System.out.println(Thread.currentThread().getName() +"---->" + i);
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        
    }
}
