package org.xiao.rain.test.jvm.stack;

/**
 * Author: xiaojl
 * Date: 2021/10/23 11:12
 */
public class LocalVariablesTest {

    public static void main(String[] args) {
        
        test1(1);
        
    }

    public static int test1(int a) {
        int b = 2;
        double d = 1000L;
        int c = a + b;
        return c;
    }
}
