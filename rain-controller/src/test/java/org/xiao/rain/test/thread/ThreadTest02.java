package org.xiao.rain.test.thread;

/**
 * 新建线程的第二种方式 runable接口
 * Author: xiaojl
 * Date: 2021/7/5 23:24
 */
public class ThreadTest02 {

    public static void main(String[] args) {
        
        Thread thread = new Thread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < 999; i++) {
                    System.out.println("分支线程----->" + i);
                }
            }
        });
        thread.start();
        for (int i = 0; i < 999; i++) {
            System.out.println("主线程----->" + i);
        }
        
        
    }
}
