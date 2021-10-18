package org.xiao.rain.test.jvm.stringtable;

/**
 * -Xmx10m -XX:+PrintStringTableStatistics -XX:+PrintGCDetails -verbose:gc
 * Author: xiaojl
 * Date: 2021/10/3 23:10
 */
public class StringTableGc {

    public static void main(String[] args) {

        for (int i = 0; i < 100; i++) {
            String.valueOf(i).intern();
        }
        
    }
}
