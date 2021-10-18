package org.xiao.rain.thread.sequence;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.LockSupport;

/**
 * 顺序输出 park
 * Author: xiaojl
 * Date: 2021/9/24 22:20
 */
@Slf4j
public class SequencePark {

    public static void main(String[] args) {
        Thread t1 = new Thread(() -> {
            LockSupport.park();
            log.debug("second");
        }, "t1");
        t1.start();
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        Thread t2 = new Thread(() -> {
            log.debug("first");
            LockSupport.unpark(t1);
        }, "t2");
        t2.start();
    }
}
