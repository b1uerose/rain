package org.xiao.rain.test.type;

import java.util.ArrayList;
import java.util.List;

/**
 * Author: xiaojl
 * Date: 2021/7/1 23:39
 */
public class TypeTest01 {
    
    public <T> List<T> tetType(T arg1) {
        List<T> list = new ArrayList<T>();
        return new ArrayList<T>();
    }

    public <U> List<U> tetType1(U arg1) {
        List<U> list = new ArrayList<U>();
        return new ArrayList<U>();
    }
}
