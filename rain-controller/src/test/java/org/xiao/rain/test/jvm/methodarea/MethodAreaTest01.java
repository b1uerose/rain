package org.xiao.rain.test.jvm.methodarea;

import java.util.concurrent.TimeUnit;

/**
 * Author: xiaojl
 * Date: 2021/10/24 16:29
 */
public class MethodAreaTest01 {

    public static void main(String[] args) {
        try {
            TimeUnit.DAYS.sleep(1);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        
    }
}
