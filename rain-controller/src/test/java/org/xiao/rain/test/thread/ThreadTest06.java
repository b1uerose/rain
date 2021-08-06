package org.xiao.rain.test.thread;

/**
 * 中止线程 推荐方式
 * Author: xiaojl
 * Date: 2021/7/6 22:02
 */
public class ThreadTest06 {

    public static void main(String[] args) {
        MyThread06 runnable = new MyThread06();
        Thread thread = new Thread(runnable);
        thread.start();

        try {
            Thread.sleep(5000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        runnable.flag = false;
    }
}

class MyThread06 implements Runnable {
    public boolean flag = true;

    @Override
    public void run() {
        for (int i = 0; i < 10; i++) {
            if (flag) {
                System.out.println(Thread.currentThread().getName() + "--->" + i);
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            } else {
                // 这里还可以做没有做完的事情 比如保存
                //doSave
                System.out.println("分支线程结束了");
                return;
            }
        }
    }
}
