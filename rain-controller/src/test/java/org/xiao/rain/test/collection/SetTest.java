package org.xiao.rain.test.collection;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;

/**
 * Author: xiaojl
 * Date:2022-06-18 11:44
 */
public class SetTest {
    
    @Test
    public void test() throws Exception {
        Set<String> oriSet = new HashSet<>();
        oriSet.add("aa");
        oriSet.add("bb");
        oriSet.add("cc");
        
        Set<String> secSet = new HashSet<>();
        secSet.add("aa");
        secSet.add("dd");
        
        oriSet.retainAll(secSet);

        System.out.println(oriSet);
        
    }
    
}
