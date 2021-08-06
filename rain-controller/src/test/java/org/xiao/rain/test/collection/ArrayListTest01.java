package org.xiao.rain.test.collection;

import org.xiao.rain.test.type.Human;
import org.xiao.rain.test.type.Parent;
import org.xiao.rain.test.type.Son;

import java.util.*;

/**
 * 
 * Author: xiaojl
 * Date: 2021/7/1 22:59
 */
public class ArrayListTest01 {

    public static void main(String[] args) {
        
        List<String> list = new ArrayList<String>();
        
        List<? extends Human> list2 = new ArrayList<>();
        
        List<? super Human> list3 = new ArrayList<>();
        list3.add(new Son());
        list3.add(new Parent());

//        Iterator<String> iterator = list.iterator();
//        while (iterator.hasNext()) {
//            String next =  iterator.next();
//        }
        
        Set<String> testset = new HashSet<String>();
        testset.add("11");
        testset.add("12");
        testset.add("13");
        testset.add("14");
        
        //创建集合testset的迭代器
        //创建集合testset的迭代器
        
        Set<String> pkset = new HashSet<String>();
        pkset.add("11");
        pkset.add("22");
        pkset.add("33");
        pkset.add("44");
        pkset.add("21");
        pkset.add("12");
        pkset.add("12");
        pkset.add("absdD");
        
        //创建集合的迭代器
        Iterator<String> iterator = pkset.iterator();
        while (iterator.hasNext()) {
            String next = iterator.next();
            System.out.println(next);
        }
        
        //key:  value:
        Map<String, String> Map = getMap();
    }
    
    public static <K, V> Map<K, V> getMap() {
        return new HashMap<>();
    }

}
