package org.xiao.rain.test.jvm.stringtable;

import java.nio.charset.StandardCharsets;
import java.util.Arrays;

/**
 * Author: xiaojl
 * Date: 2021/10/29 21:21
 */
public class StringTest02 {


    public static void main(String[] args) {

//        Integer a = 100;
//        Integer b = 100;
//        
//        Integer c = new Integer(100);
//
//        System.out.println(a == b);
//        System.out.println(a == c);
        
        String str = "我是中国人";

        byte[] bytes = str.getBytes(StandardCharsets.UTF_8);
        char[] chars = str.toCharArray();
        

        System.out.println(Arrays.toString(chars));


    }

}
