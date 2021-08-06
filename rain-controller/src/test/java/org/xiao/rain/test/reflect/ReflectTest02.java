package org.xiao.rain.test.reflect;

import java.lang.reflect.Field;
import java.lang.reflect.Modifier;

/**
 * Author: xiaojl
 * Date: 2021/7/9 12:53
 */
public class ReflectTest02 {
    public static void main(String[] args) throws ClassNotFoundException {
        Class<?> userCs = Class.forName("org.xiao.rain.test.reflect.User");

        Field[] fileds = userCs.getDeclaredFields();
        for (Field field : fileds) {
            //成员变量名称
            String fieldName = field.getName();
            System.out.println("fieldName:" + fieldName);
            
            //类型
            Class fieldType = field.getType();
            System.out.println("fieldType:" + field.getType().getName());
            
            //修饰符
            System.out.println("修饰符：" + Modifier.toString(field.getModifiers()));

            System.out.println("====================");
        }
        
    }
}

class User {
    
    private int no = 1;//这是一个Field
    public String name;//这是也是一个Field
    double balance;
    protected boolean sex;
    
    
}
