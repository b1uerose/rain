package org.xiao.rain.test.reflect;

import java.lang.reflect.Constructor;

/**
 * Author: xiaojl
 * Date: 2021/7/12 22:11
 */
public class ReflectTest05 {

    public static void main(String[] args) throws Exception {
        Class<?> beanClass = Class.forName("org.xiao.rain.test.reflect.ReflectTestBean");

        Constructor con = beanClass.getDeclaredConstructor(int.class, String.class, double.class);
        Object obj = con.newInstance(10, "123", 11.11);

        System.out.println(obj);
        
        Constructor<?> con2 = beanClass.getDeclaredConstructor();
        System.out.println(con2.newInstance());
    }
}


