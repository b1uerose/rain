package org.xiao.rain.test.thread.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 线程池测试
 * Author: xiaojl
 * Date: 2021/9/30 09:41
 */
@Slf4j
public class ThreadPoolTest {

    public static void main(String[] args) {

        ThreadPool tp = new ThreadPool(2, 1, 3000, TimeUnit.MILLISECONDS, (blockingQueue, task) -> {
//            blockingQueue.productWithTimeout(task, 1500, TimeUnit.MILLISECONDS);
            blockingQueue.product(task);
        });

        for (int i = 0; i < 4; i++) {
            int j = i;
            tp.execute(()->{
                log.debug("{}", j);
                try {
                    Thread.sleep(2000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            });
        }
    }

}
