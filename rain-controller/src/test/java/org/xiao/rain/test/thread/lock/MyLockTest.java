package org.xiao.rain.test.thread.lock;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: xiaojl
 * Date: 2021/10/1 23:03
 */
@Slf4j
public class MyLockTest {

    public static void main(String[] args) {
        
        MyLock lock = new MyLock();
        
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                log.debug("locking .....");
                
            } finally {
                log.debug("unlocking .....");
                lock.unlock();
            }
        }, "t1");
        t1.start();
        
        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                log.debug("locking .....");

            } finally {
                log.debug("unlocking .....");
                lock.unlock();
            }
        }, "t2");
        t2.start();
        
        
        
    }
}
