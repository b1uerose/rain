package org.xiao.rain.test.thread.threadpool;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayDeque;
import java.util.Deque;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.locks.Condition;
import java.util.concurrent.locks.ReentrantLock;

/**
 * 阻塞队列
 * Author: xiaojl
 * Date: 2021/9/29 17:26
 */
@Slf4j
public class BlockingQueue<T> {

    //任务队列
    private Deque<T> blockingQueue = new ArrayDeque<>();
    //任务的最大容量
    private int capcity;
    //锁
    private ReentrantLock lock = new ReentrantLock();
    //生产者等待条件变量
    private Condition producterWaitSet = lock.newCondition();
    //消费者等待条件变量
    private Condition consumerWaitSet = lock.newCondition();

    public BlockingQueue(int capcity) {
        this.capcity = capcity;
    }

    public void productWithTimeout(T task, long timeout, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(timeout);
        lock.lock();
        try {
            while (blockingQueue.size() == capcity) {
                try {
                    if (nanos <= 0) {
                        log.debug("任务等待加入队列超时{}", task);
                        return;
                    }
                    nanos = producterWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            log.debug("任务加入队列：{}", task);
            blockingQueue.addLast(task);
            consumerWaitSet.signal();
        } finally {
            lock.unlock();
        }
    }

    public void product(T task) {
        lock.lock();
        try {
            while (blockingQueue.size() == capcity) {
                try {
                    log.debug("队列已满，任务等待加入队列中 {} 。。。。", task);
                    producterWaitSet.await();
                } catch (InterruptedException e) {
                }
            }
            log.debug("任务加入队列：{}", task);
            blockingQueue.addLast(task);
            consumerWaitSet.signal();
        } finally {
            lock.unlock();
        }
    }

    public T consum() {
        lock.lock();
        try {
            while (blockingQueue.isEmpty()) {
                try {
                    log.debug("任务队列为空,等在任务加入任务队列");
                    consumerWaitSet.await();
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T task = blockingQueue.removeFirst();
            log.debug("获得任务{}", task);
            producterWaitSet.signal();
            return task;
        } finally {
            lock.unlock();
        }
    }
    
    public T consumeWithTimeout(long timeout, TimeUnit timeUnit) {
        long nanos = timeUnit.toNanos(timeout);
        lock.lock();
        try {
            while (blockingQueue.isEmpty()) {
                if(nanos <= 0) {
                    log.debug("消费者队列等待超时");
                    return null;
                }
                try {
                    log.debug("任务队列为空,等待任务加入任务队列");
                    nanos = consumerWaitSet.awaitNanos(nanos);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            T task = blockingQueue.removeFirst();
            log.debug("获得任务{}", task);
            producterWaitSet.signal();
            return task;
        } finally {
            lock.unlock();
        }
    }
    
    public void tryProduct(RejectPolicy<T> policy, T task) {
        lock.lock();
        try {
            if (blockingQueue.size() == capcity) {
                policy.reject(this, task); 
            } else {
                log.debug("任务加入队列 {}", task);
                blockingQueue.addLast(task);
                consumerWaitSet.signal();
            }
        } finally {
            lock.unlock();
        }
    } 


}
