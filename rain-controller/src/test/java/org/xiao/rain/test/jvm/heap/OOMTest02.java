package org.xiao.rain.test.jvm.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * -Xmx10m -XX:+HeapDumpOnOutOfMemoryError -XX:HeapDumpPath=/Users/xiao/Desktop/xxx.hprof
 * Author: xiaojl
 * Date: 2021/7/21 23:20
 */
public class OOMTest02 {
    public static void main(String[] args) {
        int i = 0;
        String a = "xiaojl222222222.com";
        List<String> list = new ArrayList<String>();
        while (true) {
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            list.add(a);
            a = a+a;
            i++;
        }
    }
}
