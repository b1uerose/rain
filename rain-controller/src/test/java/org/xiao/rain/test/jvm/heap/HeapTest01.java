package org.xiao.rain.test.jvm.heap;

/**
 * Author: xiaojl
 * Date: 2021/7/18 23:02
 */
public class HeapTest01 {

    public static void main(String[] args) {
        try {
            Thread.sleep(365*24*60*60);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
