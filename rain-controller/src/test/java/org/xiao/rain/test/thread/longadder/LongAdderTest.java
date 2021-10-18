package org.xiao.rain.test.thread.longadder;

import lombok.extern.slf4j.Slf4j;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.atomic.AtomicLong;
import java.util.concurrent.atomic.LongAdder;
import java.util.function.Consumer;
import java.util.function.Supplier;

/**
 * Author: xiaojl
 * Date: 2021/9/28 08:07
 */
@Slf4j
public class LongAdderTest {

    public static void main(String[] args) {
        
        add(AtomicLong::new, AtomicLong::incrementAndGet);
        
        add(LongAdder::new, LongAdder::increment);
        
    }
    
    
    public static <T> void add(Supplier<T> supplier, Consumer<T> consumer) {
        
        long startTime = System.nanoTime();
        T adder = supplier.get();
        List<Thread> threadList = new ArrayList<Thread>();
        for (int i = 0; i < 5; i++) {
            Thread t = new Thread(() -> {
                for (int j = 0; j < 1000000; j++) {
                    consumer.accept(adder);
                }
            }, "t");
            threadList.add(t);
        }
        
        threadList.forEach(Thread::start);
        threadList.forEach(t-> {
            try {
                t.join();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        });

        
        
        long endTime = System.nanoTime();
        log.debug("结果:{},耗时：{}",adder, (endTime-startTime)/1000000 +"ns");
        
        
    }
}
