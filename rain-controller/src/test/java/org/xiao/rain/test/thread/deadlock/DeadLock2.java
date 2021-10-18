package org.xiao.rain.test.thread.deadlock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 死锁
 * Author: xiaojl
 * Date: 2021/9/23 22:21
 */
@Slf4j
public class DeadLock2 {

    public static void main(String[] args) {
        
        Object obj1 = new Object();
        Object obj2 = new Object();
        
        Thread t1 = new Thread(() -> {
            synchronized (obj1) {
                log.debug("t1获得Obj1的锁");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                synchronized (obj2) {
                    log.debug("t1获取Obj2上的锁");
                    
                }
            }
        }, "t1");
       

        Thread t2 = new Thread(() -> {
            synchronized (obj2) {
                log.debug("t2获得Obj2的锁");
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                synchronized (obj1) {
                    log.debug("t2获取Obj1上的锁");
                }
            }
        }, "t2");
        t1.start();
        t2.start();
        
    }
}
