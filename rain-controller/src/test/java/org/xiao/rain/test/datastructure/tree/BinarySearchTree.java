package org.xiao.rain.test.datastructure.tree;

import org.junit.Test;

/**
 * 二叉搜索树
 * Author: xiaojl
 * Date: 2021/12/13 22:47
 */
public class BinarySearchTree {

    private TreeNode root = null;

    @Test
    public void test() {
        int[] array = new int[]{7, 3, 10, 12, 5, 1, 9, 4};
        createBinarySearchTree(array);

//        System.out.println("========删除元素2(元素2没有子节点)=======");
//        removeNode(2, root);
//        new Tree().inorderTransversal(this.root);
//        System.out.println("========删除元素1(元素1有一个子节点)=======");
//        removeNode(1, root);
//        new Tree().inorderTransversal(this.root);
        System.out.println("========删除元素3(元素3有两个子节点)=======");
        removeNode(3, root);
        new Tree().inorderTransversal(this.root);
    }

    public void createBinarySearchTree(int[] array) {
        for (int value : array) {
            TreeNode node = new TreeNode();
            node.setId(value);
            node.setValue(value);
            addTreeNode(node);
        }
        new Tree().inorderTransversal(this.root);
    }

    public void addTreeNode(TreeNode node) {
        if (root == null) {
            root = node;
        } else {
            root.addNode(node);
        }
    }

    public TreeNode findMinTreeNode(TreeNode treeNode) {
        if(treeNode == null) {
            return null;
        }
        if(treeNode.getLeftTreeNode() == null) {
            return treeNode;
        }
        return findMinTreeNode(treeNode.getLeftTreeNode());
    }

    public TreeNode removeNode(int value, TreeNode node) {
        if (node == null) {
            return node;
        }

        int nodeValue = node.getValue();
        if (nodeValue > value) {
            node.setLeftTreeNode(removeNode(value, node.getLeftTreeNode()));
        } else if (nodeValue < value) {
            node.setRightTreeNode(removeNode(value, node.getRightTreeNode()));
        } else {
            TreeNode leftTreeNode = node.getLeftTreeNode();
            TreeNode rightTreeNode = node.getRightTreeNode();
            if (leftTreeNode != null && rightTreeNode != null) {
                //找到右子树最小的节点
                TreeNode minTreeNode = findMinTreeNode(rightTreeNode);
                node.setValue(minTreeNode.getValue());
                node.setRightTreeNode(removeNode(minTreeNode.getValue(), rightTreeNode));
            } else if (leftTreeNode != null) {
                return leftTreeNode;
            } else if (rightTreeNode != null) {
                return rightTreeNode;
            } else {
                return null;
            }
        }
        
        return node;
    }

}
