package org.xiao.rain.test.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 线程休眠被打断
 * Author: xiaojl
 * Date: 2021/9/19 14:56
 */
@Slf4j
public class ThreadInterrupt1 {

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            try {
                log.debug("进入睡眠");
//                Thread.sleep(365*24*60*1000);
                TimeUnit.DAYS.sleep(365);//wait 还设有join都是一样
            } catch (InterruptedException e) {
                log.debug("睡眠被打断");
                e.printStackTrace();
            }
        }, "t1");
        t1.start();
        try {
            Thread.sleep(500);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("打断t1线程的睡眠");
        t1.interrupt();
        log.debug("t1的打断标志:{}", t1.isInterrupted());
    }
    
}
