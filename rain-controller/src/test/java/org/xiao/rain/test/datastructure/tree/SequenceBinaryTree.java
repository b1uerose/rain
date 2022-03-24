package org.xiao.rain.test.datastructure.tree;

import org.junit.Test;

/**
 * 顺序存储二叉树 数组转换成二叉树
 * Author: xiaojl
 * Date: 2021/12/5 22:40
 */
public class SequenceBinaryTree {

    @Test
    public void buildTree() {
        int[] array = new int[]{0, 1, 2, 3, 4, 5, 6, 7};
        TreeNode node = buildTree(array, 0);
        preorderTransversal(node);
    }

    public TreeNode buildTree(int[] array, int index) {
        TreeNode node = new TreeNode(array[index], "NO." + array[index]);
        int leftIndex = 2 * index + 1;
        int rightIndex = 2 * index + 2;
        if (leftIndex < array.length) {
            node.setLeftTreeNode(buildTree(array, leftIndex));
        }
        if (rightIndex < array.length) {
            node.setRightTreeNode(buildTree(array, rightIndex));
        }
        return node;
    }

    /**
     * 前序遍历
     *
     * @param treeNode
     */
    public void preorderTransversal(TreeNode treeNode) {
        if (treeNode == null) {
            return;
        }
        System.out.println(treeNode);
        if (treeNode.getLeftTreeNode() != null) {
            preorderTransversal(treeNode.getLeftTreeNode());
        }
        if (treeNode.getRightTreeNode() != null) {
            preorderTransversal(treeNode.getRightTreeNode());
        }
    }

}
