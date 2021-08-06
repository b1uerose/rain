package org.xiao.rain.test.jvm.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: xiaojl
 * Date: 2021/7/21 23:20
 */
public class OOMTest02 {
    public static void main(String[] args) {
        int i = 0;
        String a = "xiaojl1988.com";
        List<String> list = new ArrayList<String>();
        while (true) {
            list.add(a);
            a = a+a;
            i++;
        }
    }
}
