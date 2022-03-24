package org.xiao.rain.test.datastructure.tree;

import org.junit.Test;

import java.util.LinkedList;

/**
 * Author: xiaojl
 * Date: 2021/12/5 17:04
 */
public class Tree {
    
    @Test
    public void test() {
        TreeNode root = createTree();
        System.out.println("前序遍历");
        preorderTransversal(root);

        System.out.println("删除节点");
        deleteNode(root, 3);
        preorderTransversal(root);

//        System.out.println("中序遍历");
//        inorderTransversal(root);
//
//        System.out.println("后续遍历");
//        postorderTransversal(root);
    }
    
    public TreeNode createTree() {
        TreeNode root = new TreeNode(1, "1号");
        TreeNode node2 = new TreeNode(2, "2号");
        TreeNode node3 = new TreeNode(3, "3号");
        TreeNode node4 = new TreeNode(4, "4号");
        root.setLeftTreeNode(node2);
        root.setRightTreeNode(node3);
        node3.setRightTreeNode(node4);
        
        return root;
    }

    /**
     * 前序遍历
     * @param treeNode
     */
    public void preorderTransversal(TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        System.out.println(treeNode);
        if(treeNode.getLeftTreeNode() != null) {
            preorderTransversal(treeNode.getLeftTreeNode());
        }
        if(treeNode.getRightTreeNode() != null) {
            preorderTransversal(treeNode.getRightTreeNode());
        }
    }

    /**
     * 中序遍历
     * @param treeNode
     */
    public void inorderTransversal(TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        if(treeNode.getLeftTreeNode() != null) {
            inorderTransversal(treeNode.getLeftTreeNode());
        }
        System.out.println(treeNode);
        if(treeNode.getRightTreeNode() != null) {
            inorderTransversal(treeNode.getRightTreeNode());
        }
    }

    /**
     * 后续遍历
     * @param treeNode
     */
    public void postorderTransversal(TreeNode treeNode) {
        if(treeNode == null) {
            return;
        }
        if(treeNode.getLeftTreeNode() != null) {
            postorderTransversal(treeNode.getLeftTreeNode());
        }
        if(treeNode.getRightTreeNode() != null) {
            postorderTransversal(treeNode.getRightTreeNode());
        }
        System.out.println(treeNode);
    }
    
    public void deleteNode(TreeNode treeNode, int id) {
        if(treeNode == null) {
            return;
        }
        TreeNode leftNode = treeNode.getLeftTreeNode();
        TreeNode rightNode = treeNode.getRightTreeNode();
        if(leftNode != null) {
            if(leftNode.getId() == id) {
                treeNode.setLeftTreeNode(null);
            } else {
                deleteNode(leftNode, id);
            }
        }
        if(rightNode != null) {
            if(rightNode.getId() == id) {
                treeNode.setRightTreeNode(null);
            } else {
                deleteNode(rightNode, id);
            }
        }
    }
    
    
    public static int getTreeWPL(TreeNode node) {
        LinkedList<TreeNode> queue = new LinkedList<>();
        queue.add(node);
        
        int pathLength = 0;//路径长度
        int weightedPathLenght = 0;
        while (!queue.isEmpty()) {
            int length = queue.size();
            for (int i = 0; i < length; i++) {
                TreeNode treeNode = queue.pollFirst();
                TreeNode leftTreeNode = treeNode.getLeftTreeNode();
                TreeNode rightTreeNode = treeNode.getRightTreeNode();
                if(leftTreeNode == null && rightTreeNode == null) {
                    //权值 * 路径长度 = 带权路径长度
                    weightedPathLenght = weightedPathLenght + treeNode.getId() * pathLength;
                }
                if(leftTreeNode != null) {
                    queue.addLast(leftTreeNode);
                }
                if(rightTreeNode != null) {
                    queue.addLast(rightTreeNode);
                }
            }

            pathLength ++;
            
        }
        
        
        return weightedPathLenght;
    }
    
}
