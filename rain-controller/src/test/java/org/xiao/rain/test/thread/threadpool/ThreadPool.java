package org.xiao.rain.test.thread.threadpool;

import java.util.HashSet;
import java.util.concurrent.TimeUnit;

/**
 * 自定义线程池
 * Author: xiaojl
 * Date: 2021/9/29 20:03
 */
public class ThreadPool {
    
    private HashSet<WorkerThead> workers = new HashSet<>();
    
    private BlockingQueue<Runnable> blockingQueue;
    
    private int coreSize;
    
    private long timeout;
    
    private TimeUnit timeunit;
    
    private RejectPolicy<Runnable> policy;
    
    public void execute(Runnable task) {
        synchronized (workers) {
            if(workers.size() < coreSize) {
                WorkerThead thread = new WorkerThead(task, blockingQueue, timeout, timeunit, workers);
                workers.add(thread);
                thread.start();
            } else {
                blockingQueue.tryProduct(policy, task);
            }
            
        }
    }

    public ThreadPool(int coreSize, int queueCapcity, long timeout, TimeUnit timeunit, RejectPolicy<Runnable> policy) {
        this.coreSize = coreSize;
        this.timeout = timeout;
        this.timeunit = timeunit;
        this.policy = policy;
        blockingQueue = new BlockingQueue<>(queueCapcity);
    }
    
}
