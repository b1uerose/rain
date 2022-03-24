package org.xiao.rain.test.datastructure.queue;

import lombok.extern.slf4j.Slf4j;

import java.util.Scanner;

/**
 * 数组实现的环形队列
 * Author: xiaojl
 * Date: 2021/11/1 22:57
 */
@Slf4j
public class CircleArrayQueue {

    private int queueSize;
    private int front = 0;
    private int rear = 0;
    private int[] queue;
    
    public CircleArrayQueue(int queueSize) {
        this.queueSize = queueSize;
        queue = new int[queueSize];
    }
    
    private boolean isFull() {
        return (rear + 1) % queueSize == front;
    }
    
    private boolean isEmpty() {
        return rear == front;
    }

    /**
     * 入队操作
     * @param value
     */
    private void enQueue(int value) {
        if(isFull()) {
            log.debug("队列已满，不能继续添加数据！！！");
            return;
        }
        queue[rear] = value;
        rear = (rear + 1) % queueSize;
    }
    
    private int deQueue() {
        if(isEmpty()) {
            throw new RuntimeException("队列为空，无法出队");
        }
        
        int retValue = queue[front];
        front = (front + 1) % queueSize;
        return retValue;
    }
    
    public void showQueueData() {
        for (int i = front; i < front + size() ; i++) {
            int index = i % queueSize;
            log.debug("array[{}]中的值为 {}", index, queue[index]);
        }
    }
    
    public int size() {
        return (rear + queueSize - front) % queueSize;
    }
    
    public int getHeadData() {
        if(isEmpty()) {
            log.error("队列为空,无法获取数据");
            return -99999;
        }
        
        return queue[front];
    }

    public static void main(String[] args) {
        CircleArrayQueue queue = new CircleArrayQueue(4);
        char key = ' ';
        Scanner scanner = new Scanner(System.in);
        boolean loop = true;
        
        while (loop) {
            log.debug("s(show): 显示队列");
            log.debug("e(exit): 退出程序");
            log.debug("a(add): 添加数据到队列");
            log.debug("g(get): 从队列取出数据");
            log.debug("h(head): 查看队列头的数据");
            key = scanner.next().charAt(0);
            switch (key) {
                case 's' :
                    queue.showQueueData();
                    break;
                case 'e' :
                    loop = false;
                    scanner.close();
                    break;
                case 'a' :
                    log.debug("请输入一个数字");
                    int value = scanner.nextInt();
                    queue.enQueue(value);
                    break;
                case 'g' :
                    int retValue = queue.deQueue();
                    log.debug("出队{}", retValue);
                    break;
                case 'h' :
                    int headValue = queue.getHeadData();
                    log.debug("front {}", headValue);
                    break;
                default:
                    break;
            }
        }
        
    }
    
}
