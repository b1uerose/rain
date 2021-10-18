package org.xiao.rain.test.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 等待线程结束join
 * Author: xiaojl
 * Date: 2021/9/19 15:23
 */
@Slf4j
public class ThreadJoin2 {

    static int result = 0;

    public static void main(String[] args) throws InterruptedException {
        Thread t1 = new Thread(() -> {
            log.debug("开始");
            try {
                TimeUnit.SECONDS.sleep(10);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            log.debug("结束");
            result = 100;

        }, "t1");

        t1.start();
        t1.join();
        log.debug("result: {}", result);
    }
}
