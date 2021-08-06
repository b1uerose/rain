package org.xiao.rain.test.reflect;

import java.lang.reflect.Field;

/**
 * Author: xiaojl
 * Date: 2021/7/9 13:19
 */
public class ReflectTest03 {

    public static void main(String[] args) throws ClassNotFoundException, NoSuchFieldException, IllegalAccessException, InstantiationException {
        Class<? extends User> userCs = (Class<? extends User>) Class.forName("org.xiao.rain.test.reflect.User");
        
        Field noField = userCs.getDeclaredField("no");
        User obj = userCs.newInstance();
        
        noField.setAccessible(true);
        noField.set(obj, 111);
        //打破封装，可以访问私有的属性
        System.out.println(noField.get(obj));
        
    }
}
