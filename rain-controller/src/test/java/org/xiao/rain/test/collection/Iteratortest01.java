package org.xiao.rain.test.collection;

import java.util.*;

/**
 * 集合发生改变，必须重新获取迭代器对象
 * Author: xiaojl
 * Date: 2021/7/2 00:17
 */
public class Iteratortest01 {

    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        list.add("11");
        list.add("12");
        list.add("13");
        list.add("14");
        list.add("15");
        list.add("16");
        list.add("17");
        String sdd = list.get(0);
        

        Iterator<String> iterator = list.iterator();
        while (iterator.hasNext()) {
            String value = iterator.next();
            if(value.equals("14")) {
                iterator.remove();
            }
            System.out.println(value);
        }
        System.out.println(list);
        
        //key:  value:
        Map<String, String> Map = new LinkedHashMap<String, String>();
        Map.put("11", "11");
        Map.put("12", "11");
        Map.put("31", "11");
        Map.put("41", "11");
        Map.put("15", "11");
        Map.put("21", "11");
        Map.put("51", "11");
        Map.put("61", "11");
        Map.put("52", "11");
        Map.put("54", "11");
        Map.put("55", "11");

        for (String s : Map.keySet()) {
            System.out.println(s);
        }

        
    }
}
