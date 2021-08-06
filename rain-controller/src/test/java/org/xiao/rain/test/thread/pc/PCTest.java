package org.xiao.rain.test.thread.pc;

import java.util.ArrayList;
import java.util.List;

/**
 * 生产者和消费者
 * Author: xiaojl
 * Date: 2021/7/7 23:47
 */
public class PCTest {
    public static void main(String[] args) {
        List<String> storage = new ArrayList<String>();
        
        Thread producter = new Thread(new Producter(storage));
        Thread consumer = new Thread(new Consumer(storage));
        producter.setName("生产者");
        consumer.setName("消费者");
        
        producter.start();
        consumer.start();
    }
}

class Producter implements Runnable {

    private List<String> list;

    public Producter(List<String> list) {
        this.list = list;
    }
    
    @Override
    public void run() {
        int no = 0;
        while (true) {
            synchronized (list) {
                System.out.println("生产者获得锁");
                if(list.size()>0) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                String product = "string" + (++no);
                list.add(product);
                System.out.println(Thread.currentThread().getName() +"，生产了：" + product);
                list.notifyAll();
            }
        }
        
    }
}

class Consumer implements Runnable {
    private List<String> list;

    public Consumer(List<String> list) {
        this.list = list;
    }

    @Override
    public void run() {
        while (true) {
            synchronized (list) {
                System.out.println("消费者获得锁");
                if (list.size() == 0) {
                    try {
                        list.wait();
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }

                String str = list.remove(0);
                System.out.println(Thread.currentThread().getName() +"，消费了：" + str);
                list.notifyAll();
            }
        }
            
    }
}
