package org.xiao.rain.test.reflect;

import java.lang.reflect.Method;

/**
 * Author: xiaojl
 * Date: 2021/7/12 12:39
 */
public class ReflectTest04 {

    public static void main(String[] args) throws Exception {
        Class<?> methodTest = Class.forName("org.xiao.rain.test.reflect.methodTest");
        Object obj = methodTest.newInstance();
//        Method[] methods = methodTest.getDeclaredMethods();
//        for (Method method : methods) {
//            String methodName = method.getName();
//            System.out.println("方法名:" + methodName);
//            Class<?>[] parameters = method.getParameterTypes();
//            for (Class<?> parameter : parameters) {
//                System.out.println("参数" + parameter.getSimpleName());
//            }
//
//            Class<?> returnType = method.getReturnType();
//            System.out.println(returnType.getName());
//            //修饰符
//            System.out.println(Modifier.toString(method.getModifiers()));
//            
//            method.invoke(, )
//        }

        Method doOther = methodTest.getDeclaredMethod("doOther", String.class, String.class);
        doOther.setAccessible(true);
        Object retValue = doOther.invoke(obj, "abc", "123");
        System.out.println(retValue);
    }
}

class methodTest {
    
    private void doSome(String a, String b) {
        
    }
    
    private String doOther(String a, String b) {
        
        return "doOther";
    }
    
}
