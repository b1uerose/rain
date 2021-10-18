package org.xiao.rain.test.thread;

import lombok.extern.slf4j.Slf4j;

/**
 * Author: xiaojl
 * Date: 2021/9/17 23:06
 */
@Slf4j
public class Thread12 {

    public static void main(String[] args) {
        
        Thread t1 = new Thread(()->{
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                
                log.debug("t1");

            }
        }, "t1");

        Thread t2 = new Thread(()->{
            while (true) {
                try {
                    Thread.sleep(500);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }

                log.debug("t2");

            }
        }, "t2");
        
        t1.start();
        t2.start();
    }
}
