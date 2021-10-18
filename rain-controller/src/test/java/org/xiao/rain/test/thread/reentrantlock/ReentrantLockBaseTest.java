package org.xiao.rain.test.thread.reentrantlock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁 reentrantlock的基本语法
 * Author: xiaojl
 * Date: 2021/9/23 23:38
 */
@Slf4j
public class ReentrantLockBaseTest {

    static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            try {
                lock.lockInterruptibly();
            } catch (InterruptedException e) {
                log.debug("被打断");
                return;
            }
            try {
                log.debug("获取锁");
            } finally {
                lock.unlock();
            }
        }, "t1");
        
        lock.lock();
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        t1.interrupt();
    }
}
