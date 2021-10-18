package org.xiao.rain.test.thread.forkjoin;

import lombok.extern.slf4j.Slf4j;

import java.util.concurrent.RecursiveTask;

/**
 * Author: xiaojl
 * Date: 2021/10/1 21:20
 */
@Slf4j
public class RecursiveTask01 extends RecursiveTask<Integer> {
    
    private int num;

    public RecursiveTask01(int num) {
        this.num = num;
    }
    
    @Override
    protected Integer compute() {
        
        if(num == 1) {
            log.debug("join() {}, result {}", 1, 1);
            return 1;
        }

        RecursiveTask01 task = new RecursiveTask01(num - 1);
        task.fork();
        log.debug("fork() {} + {}", num, task);
        
        int forkret = task.join();
        int result = num + forkret;

        log.debug("join() {} + {} = {}", num, forkret, result);
        
        return result;
    }

    @Override
    public String toString() {
        return "{" + num + "}";
    }
}
