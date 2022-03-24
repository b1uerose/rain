package org.xiao.rain.test.datastructure.tree.redblacktree;

import org.junit.Test;

/**
 * 红黑树测试
 * Author: xiaojl
 * Date:2022-02-23 15:17
 */
public class RedBlackTreeTest {
    
    @Test
    public void test() {
        RedBlackTree<Integer> redBlackTree = new RedBlackTree<>();
        redBlackTree.add(10);
        redBlackTree.add(5);
        redBlackTree.add(20);
        redBlackTree.add(1);
        redBlackTree.add(15);
        redBlackTree.add(25);
        redBlackTree.add(18);
        redBlackTree.delete(15);

        System.out.println(123);
        
    }
}