package org.xiao.rain.test.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 线程的6中状态
 * Author: xiaojl
 * Date: 2021/9/19 18:51
 */
@Slf4j
public class ThreadState {

    public static void main(String[] args) {
        //创建了线程，没有start
        Thread t1 = new Thread(() -> {
            log.debug("new 状态");
        }, "t1");

        //runable状态 一致在运行
        Thread t2 = new Thread(() -> {
            while (true) {

            }
        }, "t2");
        t2.start();

        //线程运行完之后的中止状态
        Thread t3 = new Thread(() -> {
            
        }, "t3");
        t3.start();
        
        //timed_waiting状态,同时给class加上锁
        Thread t4 = new Thread(() -> {
            synchronized (ThreadState.class) {
                try {
                    TimeUnit.DAYS.sleep(365);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t4");
        t4.start();
        
        //等待t2结束 waiting状态
        Thread t5 = new Thread(() -> {
            try {
                t2.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t5");
        t5.start();
        //获取class的锁,因为t4已经加上锁了。这里是blocked状态
        Thread t6 = new Thread(() -> {
            synchronized (ThreadState.class) {
                
                log.debug("blocked 状态");
            }
        }, "t6");
        t6.start();
        
        final Object lock = new Object();
        
        Thread t7 = new Thread(() -> {
            synchronized (lock) {
                try {
                    lock.wait(10000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }, "t7");
        t7.start();
        
        log.debug("==================");
        log.debug("t1的状态:{}", t1.getState());
        log.debug("t2的状态:{}", t2.getState());
        log.debug("t3的状态:{}", t3.getState());
        log.debug("t4的状态:{}", t4.getState());
        log.debug("t5的状态:{}", t5.getState());
        log.debug("t6的状态:{}", t6.getState());
        log.debug("t7的状态:{}", t7.getState());
        
        
    }
    
    
    
}
