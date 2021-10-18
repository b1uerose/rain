package org.xiao.rain.test.thread.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Executors;
import java.util.concurrent.ScheduledExecutorService;
import java.util.concurrent.TimeUnit;

/**
 * Author: xiaojl
 * Date: 2021/9/30 23:25
 */
@Slf4j
public class ScheduledThreadPool {

    public static void main(String[] args) {

        ScheduledExecutorService service = Executors.newScheduledThreadPool(2);
        log.debug("start ");
//        service.schedule(() -> {
//            log.debug("scheduled 1...");
//        }, 1, TimeUnit.SECONDS);
        
        service.scheduleAtFixedRate(() -> {
            log.debug("1");
            try {
                int i = 10 / 0;
            } catch (Exception e) {
                e.printStackTrace();
            }
        }, 1, 1, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(() -> {
            log.debug("2");
        }, 1, 1, TimeUnit.SECONDS);
        service.scheduleAtFixedRate(() -> {
            log.debug("3");
        }, 1, 1, TimeUnit.SECONDS);

    }
    
}
