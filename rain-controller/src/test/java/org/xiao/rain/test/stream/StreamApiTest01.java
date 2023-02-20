package org.xiao.rain.test.stream;

import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

/**
 * Author: xiaojl
 * Date:2022-07-01 23:29
 */
public class StreamApiTest01 {
    
    @Test
    public void test() throws Exception {

        List<String> newList = Arrays.asList("xiaojl", "xiaoyutong", "sunlu", "xiao...", "xiaoxxxxx");
        //1、获取streamapi   
        List<String> collect = newList.stream().
                filter(field -> field.startsWith("x")).
                map(String::toUpperCase).
                sorted(Comparator.reverseOrder()).
                collect(Collectors.toList());

        System.out.println(collect);
    }
    
    @Test
    public void test2() throws Exception {
        String[] array = new String[] {"xiaojl", "xiaoyutong", "sunlu", "xiao...", "xiaoxxxxx"};
        
        //Arrays.stream(array).
        List<String> g = Stream.of(array).filter(item -> item.endsWith("g")).collect(Collectors.toList());
        System.out.println(g);

    }
    
    @Test
    public void testNull() throws Exception {
        String[] array = null;
        
        Stream.of(array);
        
    }
    

}
