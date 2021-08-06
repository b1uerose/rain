package org.xiao.rain.test.generic;

import java.lang.reflect.Array;

/**
 * Author: xiaojl
 * Date: 2021/7/21 12:49
 */
public class GenericArray<T> {
    
    private T[] array;

    public GenericArray(Class<?> clz, int length)  {
        this.array = (T[]) Array.newInstance(clz, 10);
    }
    
    public void put(int index, T value) {
        this.array[index] = value;
    }
    
    public T getValue(int index) {
        return this.array[index];
    }
    
}
