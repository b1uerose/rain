package org.xiao.rain.test.thread.reentrantreadwritelock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.ReentrantReadWriteLock;

/**
 * Author: xiaojl
 * Date: 2021/10/5 23:51
 */
@Slf4j
public class ReadWriteLockContainer {
    private ReentrantReadWriteLock lock = new ReentrantReadWriteLock();
    private ReentrantReadWriteLock.ReadLock readLock = lock.readLock();
    private ReentrantReadWriteLock.WriteLock writeLock = lock.writeLock();
    
    public void read() {
        log.debug("尝试获取读锁");
        readLock.lock();
        log.debug("获取到了读锁");
        try {
            log.debug("读取");
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            log.debug("释放读锁");
            readLock.unlock();
        }
    }
    
    public void write() {
        log.debug("尝试获取写锁");
        writeLock.lock();
        log.debug("获取到了写锁");
        try {
           log.debug("写入");
            try {
                Thread.sleep(100000000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        } finally {
            log.debug("释放写锁");
            writeLock.unlock();
        }
    }
}

        
