package org.xiao.rain.test.thread.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/**
 * 工作线程
 * Author: xiaojl
 * Date: 2021/9/29 20:04
 */
@Slf4j
public class WorkerThead extends Thread {

    private Runnable task;

    private BlockingQueue<Runnable> blockingQueue;

    private long timeout;

    private TimeUnit timeUnit;

    private HashSet<WorkerThead> workers;

    public WorkerThead(Runnable task, BlockingQueue<Runnable> blockingQueue, long timeout, TimeUnit timeUnit,
                       HashSet<WorkerThead> workers) {
        this.task = task;
        this.blockingQueue = blockingQueue;
        this.timeout = timeout;
        this.timeUnit = timeUnit;
        this.workers = workers;
    }

    @Override
    public void run() {
        while (task != null || (task = blockingQueue.consumeWithTimeout(timeout, timeUnit)) != null) {
            try {
                log.debug("正式执行任务:{}", task);
                task.run();

            } finally {
                task = null;
            }
        }
        synchronized (workers) {
            log.debug("工作线程被移除：{}", this);
            workers.remove(this);
        }
    }
}
