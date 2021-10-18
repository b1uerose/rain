package org.xiao.rain.test.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * Author: xiaojl
 * Date: 2021/9/19 17:14
 */
@Slf4j
public class ThreadPark {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            log.debug("线程t1开始park");
            LockSupport.park();
            log.debug("线程t1 unpark");
            //获取打断标志，并且把打断标记设置为false
            log.debug("线程t1的打断标志：{}", Thread.interrupted()); 
            LockSupport.park();
            log.debug("线程t1 unpark");
        }, "t1");
        
        t1.start();
        try {
            TimeUnit.MILLISECONDS.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
    }
}
