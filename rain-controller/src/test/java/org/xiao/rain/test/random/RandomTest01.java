package org.xiao.rain.test.random;

import java.util.Random;

/**
 * Author: xiaojl
 * Date: 2021/7/13 16:47
 */
public class RandomTest01 {

    public static void main(String[] args) {
        Random random = new Random(47);
        for (int i = 0; i < 10000; i++) {
            int intvalue = random.nextInt(47);
            if(intvalue == 0) {
                System.out.println(intvalue);
            }
        }
    }
}
