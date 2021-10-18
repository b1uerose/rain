package org.xiao.rain.test.thread.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.Arrays;
import java.util.List;
import java.util.concurrent.*;
import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: xiaojl
 * Date: 2021/9/30 11:51
 */
@Slf4j
public class JDKThreadPoolTest {

    public static void main(String[] args) {
        //fixedThreadPoolMethod();
//        cacheThreadPoolMthod();
//        testThradPoolFuncInvoiceAll();
        testThreadPoolFuncInvoiceAny();
    }

    private static void fixedThreadPoolMethod() {
        ExecutorService service = Executors.newFixedThreadPool(2, new ThreadFactory() {
            private final AtomicInteger poolNumber = new AtomicInteger(1);

            @Override
            public Thread newThread(Runnable r) {
                return new Thread(r, "pool_thread_" + poolNumber.getAndDecrement());
            }
        });
        service.execute(() -> {
            log.debug("1");
        });
        service.execute(() -> {
            log.debug("2");
        });
        service.execute(() -> {
            log.debug("3");
        });
        service.execute(() -> {
            log.debug("4");
        });
    }

    private static void cacheThreadPoolMthod() {
        ExecutorService service = Executors.newCachedThreadPool();

//        service.execute(() -> {
//             log.debug("1");
//        });
//        service.execute(() -> {
//             log.debug("2");
//        });
//        service.execute(() -> {
//             log.debug("3");
//        });
//        service.execute(() -> {
//             log.debug("4");
//        });

        Future<String> future = service.submit(() -> {
            return "123";
        });

        try {
            log.debug("{}", future.get());
        } catch (InterruptedException | ExecutionException e) {
            e.printStackTrace();
        }

        log.debug("after future get");
    }

    public static void testThradPoolFuncInvoiceAll() {
        ExecutorService service = Executors.newFixedThreadPool(2);
        try {
            List<Future<String>> futures = service.invokeAll(Arrays.asList(
                    () -> "1",
                    () -> "2",
                    () -> "3"));

            futures.forEach((future) -> {
                try {
                    String ret = future.get();
                    log.debug("{}", ret);
                } catch (InterruptedException | ExecutionException e) {
                    e.printStackTrace();
                }
            });

        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    public static void testThreadPoolFuncInvoiceAny() {

        ExecutorService service = Executors.newFixedThreadPool(2);

        try {
            String ret = service.invokeAny(Arrays.asList(() -> {
                log.debug("1");
                Thread.sleep(500);
                log.debug("end 1");
                return "1";
            }, () -> {
                log.debug("2");
                Thread.sleep(300);
                log.debug("end 2");
                return "2";
            }));
            
            log.debug(ret);
        } catch (InterruptedException e) {
            e.printStackTrace();
        } catch (ExecutionException e) {
            e.printStackTrace();
        }

    }


}
