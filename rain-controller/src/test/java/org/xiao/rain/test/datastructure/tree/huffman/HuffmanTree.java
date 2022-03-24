package org.xiao.rain.test.datastructure.tree.huffman;

import org.junit.Test;
import org.xiao.rain.test.datastructure.tree.Tree;
import org.xiao.rain.test.datastructure.tree.TreeNode;

import java.util.Collections;
import java.util.LinkedList;

/**
 * 霍夫曼树
 * Author: xiaojl
 * Date: 2021/12/9 12:37
 */
public class HuffmanTree {
    
    @Test
    public void huffmanTree() {
        int[] array = {13, 7, 8, 3, 29, 6, 1};
        TreeNode node = buildHuffmanTree(array);

        int wpl = Tree.getTreeWPL(node);
        System.out.println(wpl);
    }
    
    
    
    
    public TreeNode buildHuffmanTree(int[] array){
        LinkedList<TreeNode> deque  = new LinkedList<>();
        for (int i = 0; i < array.length; i++) {
            TreeNode node = new TreeNode(array[i], array[i]+"");
            deque.add(node);
        }
        
        while (deque.size() > 1) {
            Collections.sort(deque);
            TreeNode leftTreeNode = deque.pollFirst();
            TreeNode rightTreeNode = deque.pollFirst();
            int id = leftTreeNode.getId() + rightTreeNode.getId();
            TreeNode parentNode = new TreeNode(id, id+"");
            parentNode.setLeftTreeNode(leftTreeNode);
            parentNode.setRightTreeNode(rightTreeNode);
            deque.add(parentNode);
        }
        return deque.pollLast();
    }
}
