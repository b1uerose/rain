package org.xiao.rain.test.thread.cyclicbarrier;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.BrokenBarrierException;
import java.util.concurrent.CyclicBarrier;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * 循环栅栏测试
 * Author: xiaojl
 * Date: 2021/10/6 22:31
 */
@Slf4j
public class CyclicBarrierTest {

    public static void main(String[] args) {
        CyclicBarrier cb = new CyclicBarrier(2, () -> {
            log.debug("task1 task2 finish");
        });

        ExecutorService service = Executors.newFixedThreadPool(2);
        
        service.submit(() -> {
            try {
                log.debug("task1 begin");
                Thread.sleep(1000L);
                cb.await();
                log.debug("task1 end");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        
        service.submit(() -> {
            try {
                log.debug("task2 begin");
                Thread.sleep(2000L);
                cb.await();
                log.debug("task2 end");
            } catch (InterruptedException | BrokenBarrierException e) {
                e.printStackTrace();
            }
        });
        
        service.shutdown();
        
        
    }
    
    
    
}
