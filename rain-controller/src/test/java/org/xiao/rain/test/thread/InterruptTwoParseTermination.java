package org.xiao.rain.test.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 两阶段中止模式
 * Author: xiaojl
 * Date: 2021/9/19 16:10
 */
@Slf4j
public class InterruptTwoParseTermination {
    
    Thread monitor;

    public static void main(String[] args) throws InterruptedException {
        InterruptTwoParseTermination itpt = new InterruptTwoParseTermination();
        itpt.start();
        TimeUnit.MILLISECONDS.sleep(3500);
        itpt.stop();
    }
    
    public void start() {
        monitor = new Thread(() -> {
            Thread current = Thread.currentThread();
            while (true) {
                if (current.isInterrupted()){
                    log.debug("清理线程占用的资源,并结束线程");
                    break;
                }
                try {
                    TimeUnit.SECONDS.sleep(1);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                    //如果是在睡眠的时候被打断的,那么需要重设打断状态
                    current.interrupt();
                }
            }
        }, "monitor");
        monitor.start();
    }
    
    public void stop() {
        monitor.interrupt();
    }
}
