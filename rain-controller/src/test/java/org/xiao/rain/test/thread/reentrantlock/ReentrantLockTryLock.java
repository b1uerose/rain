package org.xiao.rain.test.thread.reentrantlock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.ReentrantLock;

/**
 * reentrantlock 的锁超时 trylock
 * Author: xiaojl
 * Date: 2021/9/24 00:05
 */
@Slf4j
public class ReentrantLockTryLock {
    
    private static ReentrantLock lock = new ReentrantLock();
    public static void main(String[] args) {
        
        Thread t1 = new Thread(() -> {
            log.debug("尝试获得锁");
            try {
                //在365天内获得锁，注意是在这个时间点内！
                if(!lock.tryLock(365, TimeUnit.DAYS)) {
                    log.debug("没有获取到锁");
                    return;
                }
            } catch (InterruptedException e) {
                e.printStackTrace();
                return;
            }
            try {
                log.debug("获取到了锁");
            } finally {
                lock.unlock();
            }
        }, "t1");
        lock.lock();
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(2);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        log.debug("主线程解锁");
        lock.unlock();
    }
}
