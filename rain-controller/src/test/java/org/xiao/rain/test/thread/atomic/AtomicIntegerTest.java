package org.xiao.rain.test.thread.atomic;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * Author: xiaojl
 * Date: 2021/9/26 12:48
 */
@Slf4j
public class AtomicIntegerTest {
    public static void main(String[] args) {
        AtomicInteger ai = new AtomicInteger(0);
        //i++ 0
        log.debug("getAndIncrement:{}", ai.getAndIncrement());
        //++i 2
        log.debug("incrementAndGet:{}", ai.incrementAndGet());

        //i-- 2
        log.debug("getAndDecrement:{}", ai.getAndDecrement());
        //--i 0
        log.debug("decrementAndGet:{}", ai.decrementAndGet());

        //0
        log.debug("getAndAdd:{}", ai.getAndAdd(100));
        //200
        log.debug("addAndGet:{}", ai.addAndGet(100));

        log.debug("getAndAdd:{}", ai.getAndUpdate((int value) -> {
            return value *10;
        }));
        
        log.debug("{}", ai.getAndAccumulate(10, (prev, x) ->  prev + x));
    }
}
