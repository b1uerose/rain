package org.xiao.rain.test.thread.atomic;

import java.util.concurrent.atomic.AtomicReference;

/**
 * Author: xiaojl
 * Date: 2021/9/26 23:28
 */
public class AtomicReferenceTest {

    public static void main(String[] args) {

        AtomicReference<AtomicTestJavaBean> ref = new AtomicReference<>();
        ref.set(new AtomicTestJavaBean("肖金龙","xiaojl", 30));

        ref.updateAndGet(prev -> {
           return new AtomicTestJavaBean("肖金龙2","xiaojl2", 32); 
        });

//        AtomicReference<String> ref = new AtomicReference<>();
//        
//        ref.set("xiaojl");
//        
//        ref.updateAndGet()
//        
//        while (true) {
//            String value = ref.get();
//            
//            String next = "hello";
//            
//            if(ref.compareAndSet(value, next)) {
//                break;
//            }
//        }
//
//        System.out.println(ref.get());
        
    }
}
