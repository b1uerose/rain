package org.xiao.rain.thread.sequence;

import lombok.extern.slf4j.Slf4j;

/**
 * 线程按顺序数据- synchroniezd wait notify的方式
 * Author: xiaojl
 * Date: 2021/9/24 22:02
 */
@Slf4j
public class SequenceSynchronized {

    static boolean isT2Finished = false;
    public static void main(String[] args) {
        Object lock = new Object();
        Thread t1 = new Thread(() -> {

            synchronized (lock) {
                while (!isT2Finished) {
                    try {
                        lock.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                log.debug("我要在后面输出");
            }

            System.out.println();

        }, "t1");
        t1.start();


        Thread t2 = new Thread(() -> {

            synchronized (lock) {
                log.debug("我要在前面输出");
                isT2Finished = true;
                lock.notifyAll();
            }

        }, "t2");
        t2.start();

    }


}
