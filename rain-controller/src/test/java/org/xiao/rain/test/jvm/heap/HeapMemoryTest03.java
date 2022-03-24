package org.xiao.rain.test.jvm.heap;

/**
 * Author: xiaojl
 * Date: 2021/7/19 00:30
 * 
 * jps 先找到线程id
 * jstat -gc 35514 查看内存占用情况
 * 
 * 方法二：-XX:+printGCDetails
 */
public class HeapMemoryTest03 {

    public static void main(String[] args) {
        long initialMemory = Runtime.getRuntime().totalMemory();
        long maxMemory = Runtime.getRuntime().maxMemory();


        System.out.println("-Xms" + initialMemory / 1024 / 1024 + "M");
        System.out.println("-Xmx" + maxMemory / 1024 / 1024 + "M");

        System.out.println(initialMemory*64/1024/1024/1024 +"G");
        System.out.println(maxMemory*4/1024/1024/1024 +"G");

        try {
            Thread.sleep(100000000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
    }
}
