package org.xiao.rain.test.thread.stampedlock;

/**
 * Author: xiaojl
 * Date: 2021/10/6 16:19
 */
public class StampedLockTest {

    public static void main(String[] args) {
        
        StampedLockContainer container = new StampedLockContainer(100);
        
        Thread t1 = new Thread(() -> {
            try {
                int data = container.read();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t1");
        t1.start();

        try {
            Thread.sleep(500L);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }

        Thread t2 = new Thread(() -> {
            try {
                container.write(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }, "t2");
        t2.start();
        
    }
    
}
