package org.xiao.rain.test.jvm;

/**
 * Author: xiaojl
 * Date: 2021/10/3 22:07
 */
public class JVMConstantPoolTest {
    
    private static int a = 100;
    private final static int b = 200;

    public static void main(String[] args) {
        
//        String s1 = "a";
//        String s2 = "b";
//        String s3 = "ab";
//        String s4 = s1 + s2;
//        String s5 = "a" + "b";
        
        String x = "ab";
        String s1 = new String("a") + new String("b");
        
        String s2 = s1.intern();

        System.out.println(s2 == x);
        System.out.println(s1 == x);
        
        
    }
    
    
}
