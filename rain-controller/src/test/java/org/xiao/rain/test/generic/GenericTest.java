package org.xiao.rain.test.generic;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

/**
 * 泛型测试
 * Author: xiaojl
 * Date: 2021/7/20 23:25
 */
public class GenericTest {
    public static void main(String[] args) throws Exception{
        
        TypeErase<Integer> erase = new TypeErase<>();
        Class<? extends TypeErase> clz = erase.getClass();

        Field[] fields = clz.getDeclaredFields();
        for (Field field : fields) {
            System.out.println(field.getName() +":" + field.getType().getSimpleName());
        }

        Method[] methods = clz.getDeclaredMethods();
        for (Method method : methods) {
            System.out.println(method.getName() +":" + method.getReturnType().getSimpleName());
        }

        EraseInfoImpl impl = new EraseInfoImpl();
        Method[] methods1 = impl.getClass().getDeclaredMethods();
        for (Method method : methods1) {
            System.out.println(method.getName() +":" + method.getReturnType().getSimpleName());
        }

        System.out.println("-------------------");

        GenericArray<String> array = new GenericArray<>(String.class, 3);
        array.put(0, "苹果");
        array.put(1, "西瓜");
        array.put(2, "葡萄");

        System.out.println(array.getValue(1));

        Class<Person> personClass = Person.class;
        Constructor<Person> constructor = personClass.getDeclaredConstructor();
        Person person = constructor.newInstance();
    }
}
