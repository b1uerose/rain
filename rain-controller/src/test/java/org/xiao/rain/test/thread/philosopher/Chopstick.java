package org.xiao.rain.test.thread.philosopher;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 筷子
 * Author: xiaojl
 * Date: 2021/9/23 23:11
 */
public class Chopstick extends ReentrantLock {
    private static final long serialVersionUID = 17993651795981116L;
    private String name;

    public Chopstick(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
