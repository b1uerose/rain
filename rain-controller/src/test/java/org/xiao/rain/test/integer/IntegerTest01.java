package org.xiao.rain.test.integer;

/**
 * int integer string 相互转换
 * Author: xiaojl
 * Date: 2021/6/28 22:40
 */
public class IntegerTest01 {

    public static void main(String[] args) {
//        Integer x = new Integer(127);
//        Integer y = new Integer(127);
//
//        System.out.println(x == y);
//
//        Integer x1 = 127;
//        Integer y1 = 127;
//
//        System.out.println(x1 == y1);
        //string->int
        int i1 = Integer.parseInt("100");
        System.out.println(i1);
        //int->string
        String s1 = String.valueOf(i1);
        
        //int->integer
        //自动装箱
        Integer it1 = i1;
        
        //integer->int 拆箱
        int i2 = it1;
        
        //string->intger
        
        Integer it2 = Integer.valueOf("01");
        //integer - >String
        
        String s2 = String.valueOf(it2);
        
        
        
    }
}
