package org.xiao.rain.test.thread.philosopher;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.TimeUnit;

/**
 * 哲学家
 * Author: xiaojl
 * Date: 2021/9/23 23:10
 */
@Slf4j
public class Philosopher extends Thread {

    private Chopstick left;
    private Chopstick right;
    private String name;

    public Philosopher(String name, Chopstick left, Chopstick right) {
        this.left = left;
        this.right = right;
        this.name = name;
        this.setName(name);
    }

    private void eat() {
        log.debug(this.name + " eating");
        try {
            TimeUnit.SECONDS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }

    //synchronized会造成死锁
//    @Override
//    public void run() {
//        while (true) {
//            synchronized (left) {
//                synchronized (right) {
//                    eat();
//                }
//            }
//        }
//    }


    @Override
    public void run() {
        while (true) {
            if (left.tryLock()) {
                try {
                    if (right.tryLock()) {
                        try {
                            eat();
                        } finally {
                            right.unlock();
                        }
                    }
                } finally {
                    left.unlock();
                }
            }
        }
    }
}
