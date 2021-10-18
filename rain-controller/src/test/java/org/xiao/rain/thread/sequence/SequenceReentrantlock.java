package org.xiao.rain.thread.sequence;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 顺序输出，可重入锁 reentrantlock
 * Author: xiaojl
 * Date: 2021/9/24 22:14
 */
@Slf4j
public class SequenceReentrantlock {
    
    volatile static boolean ist2finished = false;
    public static void main(String[] args) {
        ReentrantLock lock = new ReentrantLock();
        Condition waitSet = lock.newCondition();
        Thread t1 = new Thread(() -> {
            lock.lock();
            try {
                while (!ist2finished) {
                    try {
                        waitSet.await();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }       
                log.debug("second");
            } finally {
                lock.unlock();
            }
        }, "t1");
        t1.start();
        
        Thread t2 = new Thread(() -> {
            lock.lock();
            try {
                log.debug("first");
                ist2finished = true;
                waitSet.signal();
            } finally {
                lock.unlock();
            }
        }, "t2");
        t2.start();
        
        
    }
}
