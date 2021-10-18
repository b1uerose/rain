package org.xiao.rain.test.thread.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.SynchronousQueue;

/**
 * synchronousqueue测试
 * Author: xiaojl
 * Date: 2021/9/30 12:48
 */
@Slf4j
public class SynchronousQueueTest {
    
    private static final SynchronousQueue<Integer> queue = new SynchronousQueue<>();

    public static void main(String[] args) {
        
        Thread t1 = new Thread(() -> {
            try {
                log.debug("put 1.....");
                queue.put(1);
                log.debug("1 is tookaway");
                log.debug("put 2.....");
                queue.put(2);
                log.debug("2 is tookaway");
                
            }catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        Thread t2 = new Thread(() -> {
            try {
                log.debug("taking 1");
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");
        t2.start();

        try {
            Thread.sleep(1000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
        Thread t3 = new Thread(() -> {
            log.debug("taking 2");
            try {
                queue.take();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t3");
        t3.start();


    }
    
}
