package org.xiao.rain.test.datastructure.tree.redblacktree;

import java.util.Map;
import java.util.TreeMap;

import org.junit.Test;

/**
 * 红黑树 treemap调试
 * Author: xiaojl
 * Date: 2022/2/23 09:27
 */
public class TreeMapTest {
    
    @Test
    public void testTreeMap() {

        Map<Integer, Integer> treeMap = new TreeMap<>();

        treeMap.put(5, 5);
        treeMap.put(3, 3);
        treeMap.put(10, 10);
        treeMap.put(4, 4);
        treeMap.put(13, 13);
        treeMap.put(7, 7);
        
        treeMap.remove(3);
        
        
    }
    
}
