package org.xiao.rain.test.annotation;

import java.lang.reflect.Field;

/**
 * Author: xiaojl
 * Date: 2021/7/13 00:13
 */
@ID
public class Student {
    
    int id = 12;

    public static void main(String[] args) throws Exception {
        Class<?> studentClass = Class.forName("org.xiao.rain.test.annotation.Student");
        ID id = studentClass.getAnnotation(ID.class);
        id.value();
        if(studentClass.isAnnotationPresent(ID.class)) {
            Field[] fields = studentClass.getDeclaredFields();
//            if (fields.length == 0) {
//                throw new RuntimeException("缺少属性");
//            }
            
            boolean isExitIdField = false;
            for (Field field : fields) {
                String name = field.getName();
                System.out.println(name);
                if("id".equals(name)) {
                    isExitIdField = true;
                    break;
                }
            }
            
            if(!isExitIdField) {
                throw new RuntimeException("缺少id属性");
            } else {
                System.out.println("存在id属性");
            }
        } else {
            System.out.println("该类[" + studentClass.getCanonicalName()+"]没有ID注解");
        }
    }
    
    
    
}
