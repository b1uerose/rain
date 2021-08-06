package org.xiao.rain.test.jvm;

/**
 * Author: xiaojl
 * Date: 2021/7/14 22:56
 */
public class JVMTest01 {
    
    private static int num = 1;
    
    static {
        num = 2;
        num2 = 20;
    }
    
    private static int num2 = 10;

    public static void main(String[] args) {
        int i = 1;
        int j = 2;
        int z = i + j;
        System.out.println(z);
    }
}
