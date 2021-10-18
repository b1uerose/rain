package org.xiao.rain.test.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * 新建线程的第二种方式 runable接口
 * Author: xiaojl
 * Date: 2021/7/5 23:24
 */
@Slf4j
public class ThreadTest02 {

    public static void main(String[] args) {
        
        Thread thread = new Thread(() -> {
            for (int i = 0; i < 999; i++) {
                log.debug("分支线程----->" + i);
            }
        });
        thread.setName("t1");
        thread.start();
        for (int i = 0; i < 999; i++) {
            log.debug("主线程----->" + i);
        }
    }
}
