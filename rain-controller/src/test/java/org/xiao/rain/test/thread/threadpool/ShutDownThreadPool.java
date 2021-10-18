package org.xiao.rain.test.thread.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * Author: xiaojl
 * Date: 2021/9/30 22:24
 */
@Slf4j
public class ShutDownThreadPool {
    public static void main(String[] args) {

        ExecutorService service = Executors.newFixedThreadPool(2);

        Future<Integer> future1 = service.submit(() -> {
            log.debug("task1 is running....");
            Thread.sleep(1000);
            log.debug("task1 is finish....");
            return 1;
        });
        Future<Integer> future2 = service.submit(() -> {
            log.debug("task2 is running....");
            Thread.sleep(1000);
            log.debug("task2 is finish....");
            return 2;
        });
        Future<Integer> future3 = service.submit(() -> {
            log.debug("task3 is running....");
            Thread.sleep(1000);
            log.debug("task3 is finish....");
            return 3;
        });
//        service.shutdown();
//        try {
//            service.awaitTermination(3, TimeUnit.SECONDS);
//        } catch (InterruptedException e) {
//            e.printStackTrace();
//        }
        List<Runnable> runnables = service.shutdownNow();
        log.debug("do others....");
        log.debug("task in queue {}", runnables);
    }
}
