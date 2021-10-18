package org.xiao.rain.test.thread;

import lombok.extern.slf4j.Slf4j;
import org.openjdk.jol.info.ClassLayout;
import org.xiao.rain.test.lambda.LambdaPerson;

/**
 * Author: xiaojl
 * Date: 2021/9/20 13:23
 */
@Slf4j
public class ThreadBiasedLock {

    public static void main(String[] args) {

        LambdaPerson a = new LambdaPerson();

        
//        log.debug(ClassLayout.parseInstance(a).toPrintable());
//        ClassLayout.parseInstance(a).toPrintable();


        System.out.println(ClassLayout.parseInstance(a).toPrintable());


        synchronized (a) {
            System.out.println(ClassLayout.parseInstance(a).toPrintable());
        }
        System.out.println(ClassLayout.parseInstance(a).toPrintable());

    }
    
    
}
