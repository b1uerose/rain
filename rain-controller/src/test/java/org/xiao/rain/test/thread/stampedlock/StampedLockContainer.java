package org.xiao.rain.test.thread.stampedlock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.locks.StampedLock;

/**
 * stampedlock
 * Author: xiaojl
 * Date: 2021/10/6 15:59
 */
@Slf4j
public class StampedLockContainer {

    private int data;

    public StampedLockContainer(int data) {
        this.data = data;
    }

    private StampedLock lock = new StampedLock();

    public int read() throws InterruptedException {
        long stamp = lock.tryOptimisticRead();
        log.debug("尝试乐观读{}", stamp);
        Thread.sleep(1000L);
        //验戳
        if (lock.validate(stamp)) {
            log.debug("验戳成功");
            return data;
        }

        log.debug("升级为读锁");
        //锁升级
        try {
            stamp = lock.readLock();
            log.debug("获得读锁{}", stamp);
            Thread.sleep(1000L);
            log.debug("获取data {}", data);
            return data;
        } finally {
            log.debug("释放读锁{}", stamp);
            lock.unlockRead(stamp);
        }
    }

    public void write(int data) throws InterruptedException {
        long stamp = lock.writeLock();
        log.debug("获得写锁{}", stamp);
        try {
            Thread.sleep(1000L);
            //更新数据
            this.data = data;
        } finally {
            log.debug("释放写锁{}", stamp);
            lock.unlockWrite(stamp);
        }
    }


}
