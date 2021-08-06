package org.xiao.rain.test.jvm.jvmstack;

/**
 * 
 * Author: xiaojl
 * Date: 2021/7/17 15:30
 */
public class OperandStackTest01 {
    
    public void testOperandStack() {
        int i = 10;
        int j = 20;
        int k = i + j;
    }
    
    public int getSum() {
        return 100;
    }
    
    public void testSum() {
        int i = getSum();
        int j = 10;
        int k = i + j;
    }
}
