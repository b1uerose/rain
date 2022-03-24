package org.xiao.rain.test.jvm.classloader;

import java.util.HashMap;
import java.util.Map;

/**
 * Author: xiaojl
 * Date: 2021/11/10 14:11
 */
public class BlockTest {
    
    private static int num1 = 10;
    
    static {
        int num2 = 20;
    }

    {
        num1 = 30;
    }
    
    public BlockTest() {
        num1 = 40;
    }

    public static void main(String[] args) {
        
        //key:  value:
        Map<String, String> Map = new HashMap<String, String>();
//        Map.get()
    }
    
    
    
}
