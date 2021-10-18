package org.xiao.rain.test.thread.reentrantlock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantLock;

/**
 * Author: xiaojl
 * Date: 2021/10/2 09:45
 */
@Slf4j
public class ReentrantLockTest {

    public static void main(String[] args) {

        ReentrantLock lock = new ReentrantLock();
        
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                log.debug("阻塞中");
            } finally {
                lock.unlock();
            }
        }, "t1");
        t1.start();

        try {
            Thread.sleep(100);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                
            } finally {
                lock.unlock();
            }
        }, "t2");
        t2.start();
        
    }
    
    
    
}
