package org.xiao.rain.test.thread;

import java.util.concurrent.Callable;
import java.util.concurrent.FutureTask;

/**
 * Author: xiaojl
 * Date: 2021/7/8 09:24
 */
public class FutureTaskTest02 {
    public static void main(String[] args) {

        FutureTask task = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                return null;
                }
        });
        
//        Thread t1 = new thread


//        Thread t1 = new thread
        
    }
        

}



