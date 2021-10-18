package org.xiao.rain.test.thread.reentrantreadwritelock;

/**
 * Author: xiaojl
 * Date: 2021/10/4 14:36
 */
public class ReentrantReadWriteLockTest {
    

    private static ReadWriteLockContainer container = new ReadWriteLockContainer();

    public static void main(String[] args) throws InterruptedException {
        
        Thread t0 = new Thread(() -> {
            container.write();
        }, "t0");
        t0.start();
        Thread.sleep(100L);
        Thread t1 = new Thread(() -> {
            container.read();
        }, "t1");
        t1.start();
////        Thread.sleep(10L);
////        Thread t2 = new Thread(() -> {
////            container.read();
////        }, "t2");
////        t2.start();
//        Thread.sleep(10L);
//        Thread t3 = new Thread(() -> {
//            container.write();
//        }, "t3");
//        t3.start();
//        Thread.sleep(10L);
//        Thread t4 = new Thread(() -> {
//            container.read();
//        }, "t4");
//        t4.start();
        
        
        
    }
    
}
