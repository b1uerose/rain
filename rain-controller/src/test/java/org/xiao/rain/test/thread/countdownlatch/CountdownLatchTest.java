package org.xiao.rain.test.thread.countdownlatch;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.CountDownLatch;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

/**
 * countdownlatch测试
 * Author: xiaojl
 * Date: 2021/10/6 22:20
 */

@Slf4j
public class CountdownLatchTest {

    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(3);

        CountDownLatch countDownLatch = new CountDownLatch(3);
        
        service.execute(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("before countDown:{}", countDownLatch.getCount());
            countDownLatch.countDown();
            log.debug("after countDown:{}", countDownLatch.getCount());
        });

        service.execute(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("before countDown:{}", countDownLatch.getCount());
            countDownLatch.countDown();
            log.debug("after countDown:{}", countDownLatch.getCount());
        });

        service.execute(() -> {
            try {
                Thread.sleep(1000L);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("before countDown:{}", countDownLatch.getCount());
            countDownLatch.countDown();
            log.debug("after countDown:{}", countDownLatch.getCount());
        });
        
        log.debug("等待结束");
        try {
            countDownLatch.await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        log.debug("结束");
        service.shutdown();
    }
    
    
}
