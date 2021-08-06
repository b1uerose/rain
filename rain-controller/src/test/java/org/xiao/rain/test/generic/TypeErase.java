package org.xiao.rain.test.generic;

import java.util.List;

/**
 * Author: xiaojl
 * Date: 2021/7/21 12:34
 */
public class TypeErase<T extends Number> {
    
    private T value;

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }
    
    public <E extends List> E getList(E e) {
        return e;
    }
    
}
