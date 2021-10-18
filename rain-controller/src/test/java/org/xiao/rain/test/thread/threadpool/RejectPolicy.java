package org.xiao.rain.test.thread.threadpool;

/**
 * Author: xiaojl
 * Date: 2021/9/30 09:34
 */
@FunctionalInterface
public interface RejectPolicy<T> {
    public void reject(BlockingQueue<T> blockingQueue, T task);
}
