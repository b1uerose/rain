package org.xiao.rain.test.jvm.heap;

import java.util.concurrent.TimeUnit;

/**
 * Author: xiaojl
 * Date: 2021/10/3 16:30
 */
public class JvisualvmTest {

    public static void main(String[] args) {
        try {
            TimeUnit.DAYS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
    
}
