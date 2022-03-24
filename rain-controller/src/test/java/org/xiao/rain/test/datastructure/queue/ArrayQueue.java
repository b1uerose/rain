package org.xiao.rain.test.datastructure.queue;

import lombok.extern.slf4j.Slf4j;

/**
 * 队列 数组实现
 * Author: xiaojl
 * Date: 2021/11/1 12:38
 */
@Slf4j
public class ArrayQueue {
    
    private int queueSize;
    private int front = -1;
    private int rear = -1;
    private int[] queue;
    
    public ArrayQueue(int queueSize) {
        this.queueSize = queueSize;
        queue = new int[queueSize];
    }
    
    public boolean isEmpty() {
        return front == rear;
    }
    
    public boolean isFull() {
        return rear == queueSize - 1;
    }
    
    public void addQueue(int data) {
        
        if(isFull()) {
           log.debug("队列已满,不能继续添加数据");
            return;
        }
        log.debug("添加数据:{}", data);
        //1、索引+1  2、填充数据
        queue[++rear] = data;
    }
    
    public int getDataFromQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空,无法获取数据");
        }
        front++;
        int retData = queue[front];
        log.debug("获取数据数据:{}", retData);
        return retData;
    }

    public static void main(String[] args) {
        
        ArrayQueue queue = new ArrayQueue(3);
        queue.addQueue(1);
        queue.addQueue(2);
        queue.addQueue(3);
        queue.addQueue(4);
        
        queue.getDataFromQueue();
        queue.getDataFromQueue();
        queue.getDataFromQueue();
        queue.getDataFromQueue();
        queue.getDataFromQueue();
        
    }
}
