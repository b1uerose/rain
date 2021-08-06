package org.xiao.rain.test.thread;

/**
 * 线程start() 开辟栈空间，自动调用线程的run方法
 * Author: xiaojl
 * Date: 2021/7/5 23:15
 */
public class ThreadTest01 {

    public static void main(String[] args) {
        
        MyThread thread = new MyThread();
        //start 启用一个分支线程，在jvm中开辟一个新的栈 ,start方法就结束了,线程启动成功，会自动调用行程的run方法
        //run 方法会在分支线程的底部，run和main是平级的
        thread.start();
        for (int i = 0; i < 999; i++) {
            System.out.println("主线程----->" + i);
        }
    }
}

class MyThread extends Thread {

    @Override
    public void run() {
        for (int i = 0; i < 999; i++) {
            System.out.println("分支线程----->" + i);
        }
    }
}
