package org.xiao.rain.test.jvm.heap;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: xiaojl
 * Date: 2021/10/24 10:13
 */
public class OOMTest03 {

    public static void main(String[] args) {

        List<String> list = new ArrayList<String>();
        String a = "test";
        while (true) {
            list.add(a);
            a = a + a;
        }


    }

}
