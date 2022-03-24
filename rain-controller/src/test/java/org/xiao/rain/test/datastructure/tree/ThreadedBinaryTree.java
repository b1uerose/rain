package org.xiao.rain.test.datastructure.tree;

import org.junit.Test;

/**
 * 线索化二叉树
 * 有2n-(n-1)个空指针
 * Author: xiaojl
 * Date: 2021/12/5 23:22
 */
public class ThreadedBinaryTree {
    
    public void test() {
        
    }
    
    public TreeNode buildTree() {
        TreeNode root = new TreeNode(1, "1");
        TreeNode node3 = new TreeNode(3, "3");
        TreeNode node8 = new TreeNode(8, "8");
        TreeNode node10 = new TreeNode(10, "10");
        TreeNode node6 = new TreeNode(6, "6");
        TreeNode node14 = new TreeNode(14, "14");
        
        root.setLeftTreeNode(node3);
        root.setRightTreeNode(node6);
        node3.setLeftTreeNode(node8);
        node3.setRightTreeNode(node10);
        node6.setLeftTreeNode(node14);
        return root;
    }
    
    @Test
    public void threadedNode() {
        TreeNode node = buildTree();
        inorderTransversal(node);
        System.out.println(123);

        traversalTreadedNode(node);
    }
    
    public void traversalTreadedNode(TreeNode root) {
        TreeNode node = root;
        while(node != null) {
            
            while(node.getLeftNodeType() ==0 && node.getLeftTreeNode() != null) {
                node = node.getLeftTreeNode();
            }
            System.out.println(node);
            if(node.getRightNodeType() == 1) {
                node = node.getRightTreeNode();
                System.out.println(node);
            }
            node = node.getRightTreeNode();
        }
    }
    
    TreeNode prenode = null;
    public void inorderTransversal(TreeNode node) {
        
        TreeNode leftNode = node.getLeftTreeNode();
        TreeNode rightNode = node.getRightTreeNode();
        if(leftNode != null) {
            inorderTransversal(leftNode);
        }
        
        if(prenode != null) {
            if(prenode.getRightTreeNode() == null) {
                prenode.setRightTreeNode(node);
                prenode.setRightNodeType(1);
            }
            
            if(node.getLeftTreeNode() == null) {
                node.setLeftNodeType(1);
                node.setLeftTreeNode(prenode);
            }
        }
        prenode = node;
        
        if(rightNode != null) {
            inorderTransversal(rightNode);
        }
        
        
        
    }
    
    
    
}
