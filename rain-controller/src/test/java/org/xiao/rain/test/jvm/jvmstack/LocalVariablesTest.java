package org.xiao.rain.test.jvm.jvmstack;

/**
 * Author: xiaojl
 * Date: 2021/7/17 01:01
 */
public class LocalVariablesTest {

    public static void main(String[] args) {
        String user = "xiaojl";
        String psd = "123";
        LocalVariablesTest test = new LocalVariablesTest();
        test.test(user, psd);
        long abs = 12312L;
        String xxx = "123";
    }
    
    public static long teststatic(String abc, int[] intarray) {
        
        double abs = 11.1;
        String hello = "123";
        float test = 11.1f;
        
        return 100L;
        
    }
    
    public void test(String user, String psd) {
        String key = user + psd;

        System.out.println(key);
    }
}
