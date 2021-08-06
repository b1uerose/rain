package org.xiao.rain.test.generic;

/**
 * 泛型父类
 * 1、泛型的子类，要和父类的泛型的保持一致
 * 2、非泛型子类，父类用泛型的话要明确数据类型
 * Author: xiaojl
 * Date: 2021/7/20 23:23
 */
public class Father<T> {
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
}
