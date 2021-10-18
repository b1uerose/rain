package org.xiao.rain.test.thread.forkjoin;

import java.util.concurrent.ForkJoinPool;

/**
 * Author: xiaojl
 * Date: 2021/10/1 21:20
 */
public class ForkJoinTest01 {

    public static void main(String[] args) {
        ForkJoinPool pool = new ForkJoinPool(4);
        pool.invoke(new RecursiveTask01(5));
    }
    
}
