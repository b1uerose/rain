package org.xiao.rain.test.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: xiaojl
 * Date: 2021/9/17 22:33
 */
@Slf4j
public class Thread11 {

    public static void main(String[] args) {
        Runnable runnable = () -> {
            log.debug("lambda创建新线程");
        };
        
        Thread thread = new Thread(runnable, "t1");
        thread.start();
    }
}
