package org.xiao.rain.test.jvm.stringtable;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: xiaojl
 * Date: 2021/10/28 22:58
 */
public class StringTest01 {
    
    String str = new String("good");
    char[] array = new char[]{'t', 'e', 's', 't'};
    
    public void test(String str, char[] array, List<String> list) {
        System.out.println(str.hashCode());
        str = "test ok";
        System.out.println(str.hashCode());
        array[0] = 'b';

        list = new ArrayList<>();
        list.add("345");
    }

    public static void main(String[] args) {
        StringTest01 test = new StringTest01();
        List<String> list = new ArrayList<String>();
        list.add("123");
        System.out.println(test.str.hashCode());
        test.test(test.str, test.array, list);
        System.out.println(list.toString());
        System.out.println(test.str.hashCode());
        System.out.println(test.str);
        System.out.println(test.array);
    }
    
}
