package org.xiao.rain.test.generic;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

/**
 * Author: xiaojl
 * Date: 2021/7/21 00:19
 */
public class GenericMethod {
    
    public <E> E getProduct(List<E> list) {
        Random rand = new Random(47);
        return list.get(rand.nextInt(list.size()));
    }

    public static void main(String[] args) {
        GenericMethod genericMethod = new GenericMethod();
        List<String> list1 = new ArrayList<String>();
        list1.add("hello1");
        list1.add("hello2");
        list1.add("hello3");
        list1.add("hello4");
        String product = genericMethod.getProduct(list1);
        System.out.println(product);
    }
}
