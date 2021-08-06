package org.xiao.rain.test.annotation;

/**
 * 测试注解
 * 类型
 * byte short int long float double boolean char String Class Enum
 * Author: xiaojl
 * Date: 2021/7/12 23:23
 */
public @interface MyAnnotation {
    
    String[] value();
    
    String name() default "";
    
    int age() default 25;
}
