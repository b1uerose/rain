package org.xiao.rain.test.thread.reentrantlock;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * reentrantlock的多条件变量
 * Author: xiaojl
 * Date: 2021/9/24 21:39
 */
@Slf4j
public class ReentrantLockAwait {

    private static ReentrantLock lock = new ReentrantLock();

    private static Condition waitCigaretteQueue = lock.newCondition();
    private static Condition waitTakeOffQueue = lock.newCondition();

    private static boolean isGetCigarette = false;
    private static boolean isGetTakeOff = false;

    public static void main(String[] args) {

        Thread t1 = new Thread(() -> {
            log.debug("有烟吗？{}", isGetCigarette ? "有" : "没有");
            lock.lock();
            while (!isGetCigarette) {
                log.debug("没有烟呐，干不下去活了，我要先去等烟的房间休息一下！");
                try {
                    waitCigaretteQueue.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                log.debug("烟来了，我要开始干活了");

            } finally {
                lock.unlock();
            }
        }, "等烟的线程");
        t1.start();

        Thread t2 = new Thread(() -> {
            log.debug("有吃的吗？{}", isGetCigarette ? "有" : "没有");
            lock.lock();
            while (!isGetTakeOff) {
                log.debug("没有吃呐，干不下去活了，我要先去等外卖的房间休息一下！");
                try {
                    waitTakeOffQueue.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }

            try {
                log.debug("外卖来了，我要开始干活了");
            } finally {
                lock.unlock();
            }
        }, "等外卖的线程");
        t2.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        Thread t3 = new Thread(() -> {
            lock.lock();
            
            try {
                log.debug("烟来咯！！！");
                isGetCigarette = true;
                waitCigaretteQueue.signal();
            } finally {
                lock.unlock();
            }
            
        }, "t3");
        t3.start();

        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        Thread t4 = new Thread(() -> {
            lock.lock();
            try {
                log.debug("外卖来咯");
                isGetTakeOff = true;
                waitTakeOffQueue.signal();
            } finally {
                lock.unlock();
            }
        }, "t4");
        t4.start();
        
        
    }

}
