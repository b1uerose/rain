package org.xiao.rain.test.thread;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.FutureTask;

/**
 * Author: xiaojl
 * Date: 2021/7/8 09:24
 */
@Slf4j
public class FutureTaskTest02 {
    public static void main(String[] args) throws ExecutionException, InterruptedException {

        FutureTask task = new FutureTask<String>(new Callable<String>() {
            @Override
            public String call() throws Exception {
                log.debug("futrue task runing");
                Thread.sleep(2000);
                return "hello word";
            }
        });
        Thread t1 = new Thread(task, "t1");
        t1.start();
        log.debug("{}", task.get());
        log.debug("2sec later");

//        Thread t1 = new thread


//        Thread t1 = new thread

    }


}



