package org.xiao.rain.test.thread.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicStampedReference;

/**
 * Author: xiaojl
 * Date: 2021/9/27 12:37
 */
@Slf4j
public class AtomicStampedReferenceTest {

    public static void main(String[] args) {
        AtomicTestJavaBean initRef = new AtomicTestJavaBean("肖金龙", "xiaojl", 23);
        AtomicStampedReference<AtomicTestJavaBean> reference = new AtomicStampedReference<>(initRef, 0);
        
        
        Thread t1 = new Thread(() -> {
            
            int stamp = reference.getStamp();
            AtomicTestJavaBean prev = reference.getReference();
            AtomicTestJavaBean newRef = new AtomicTestJavaBean("孙璐", "sunl", 22);
            boolean isUpdate = reference.compareAndSet(prev, newRef, stamp, stamp+1);
            
        }, "t1");
        t1.start();
        
        Thread t2 = new Thread(() -> {
            
        }, "t2");
        t2.start();
        
        
    }
    
    
}
