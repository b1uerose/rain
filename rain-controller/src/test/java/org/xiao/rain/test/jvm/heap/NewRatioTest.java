package org.xiao.rain.test.jvm.heap;

/**
 * 堆空间新生代和老年代的比例
 * 默认是1：2
 * -XX:NewRatio=3 新生代1 老年代3 比例是1：3
 * Author: xiaojl
 * Date: 2021/7/19 22:42
 */
public class NewRatioTest {
    public static void main(String[] args) {

        System.out.println("test new ratio");

        try {
            Thread.sleep(10000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
