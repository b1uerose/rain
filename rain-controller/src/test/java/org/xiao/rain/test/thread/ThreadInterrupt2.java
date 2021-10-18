package org.xiao.rain.test.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 非阻塞的线程， 被其他线程打断，isinterrupt的标志为true
 * Author: xiaojl
 * Date: 2021/9/19 15:50
 */
@Slf4j
public class ThreadInterrupt2 {

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            while (true) {
                boolean isInterrupt = Thread.currentThread().isInterrupted();
                if (isInterrupt) {
                    log.debug("被打断了,停止运行！");
                    break;
                }
            }
        }, "t1");
        
        t1.start();
        TimeUnit.MILLISECONDS.sleep(1);
        //打断非阻塞状态的t1线程
        t1.interrupt();
    }
}
