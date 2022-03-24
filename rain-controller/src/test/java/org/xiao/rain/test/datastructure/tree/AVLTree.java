package org.xiao.rain.test.datastructure.tree;

import org.junit.Test;

/**
 * 平衡二叉树
 * Author: xiaojl
 * Date: 2021/12/13 22:47
 */
public class AVLTree {

    private TreeNode root = null;

    @Test
    public void test() {
        int[] array = new int[]{3, 2, 1, 4, 5, 6, 7, 10, 9, 8};
//        createBinarySearchTree(array);
//        new Tree().inorderTransversal(this.root);

//        System.out.println("树的高度：" + root.height());
//        System.out.println("左子树的高度：" + root.getLeftTreeNodeHeight());
//        System.out.println("右子树的高度：" + root.getRightTreeNodeHeight());

        for (int i = 0; i < array.length; i++) {
            int value = array[i];
            root = insert(value, root);
        }

        new Tree().inorderTransversal(this.root);
    }

    public TreeNode insert(int value, TreeNode node) {
        if (node == null) {
            return new TreeNode(value, value);
        }
        int curNodeValue = node.getValue();
        if (value > curNodeValue) {
            node.setRightTreeNode(insert(value, node.getRightTreeNode()));
        } else if (value < curNodeValue) {
            node.setLeftTreeNode(insert(value, node.getLeftTreeNode()));
        }
        return balance(node);
    }

    /**
     * 平衡二叉树
     *
     * @param node
     * @return
     */
    private TreeNode balance(TreeNode node) {
        TreeNode leftTreeNode = node.getLeftTreeNode();
        TreeNode rightTreeNode = node.getRightTreeNode();
        int leftNodeHeight = getTreeNodeHeight(leftTreeNode);
        int rightNodeHeight = getTreeNodeHeight(rightTreeNode);
        if (rightNodeHeight - leftNodeHeight > 1) {
            if (getTreeNodeHeight(rightTreeNode.getLeftTreeNode()) > getTreeNodeHeight(rightTreeNode.getRightTreeNode())) {
                //双旋转
                node = doubleRotateWithRightChild(node);
            } else {
                node = rotateWithRightChild(node);
            }
        } else if (leftNodeHeight - rightNodeHeight > 1) {
            if (getTreeNodeHeight(leftTreeNode.getLeftTreeNode()) < getTreeNodeHeight(leftTreeNode.getRightTreeNode())) {
                node = doubleRotateWithLeftChild(node);
            } else {
                node = rotateWithLeftChild(node);
            }
        }

        //重算node的高度
        node.setHeight(Math.max(getTreeNodeHeight(node.getLeftTreeNode()),
                getTreeNodeHeight(node.getRightTreeNode())) + 1);

        return node;
    }

    private int getTreeNodeHeight(TreeNode node) {
        return node == null ? -1 : node.getHeight();

    }

    /**
     * 单旋转，左子节点往右旋转
     *
     * @param node
     * @return
     */
    private TreeNode rotateWithLeftChild(TreeNode node) {
        TreeNode rotateNode = node.getLeftTreeNode();
        node.setLeftTreeNode(rotateNode.getRightTreeNode());
        rotateNode.setRightTreeNode(node);

        //重算节点的高度
        node.setHeight(Math.max(getTreeNodeHeight(node.getLeftTreeNode()),
                getTreeNodeHeight(node.getRightTreeNode())) + 1);
        rotateNode.setHeight(Math.max(getTreeNodeHeight(rotateNode.getLeftTreeNode()), node.getHeight()) + 1);
        return rotateNode;
    }

    /**
     * 单旋转，右子节点往左旋转
     *
     * @param node
     * @return
     */
    private TreeNode rotateWithRightChild(TreeNode node) {
        TreeNode rotateNode = node.getRightTreeNode();
        node.setRightTreeNode(rotateNode.getLeftTreeNode());
        rotateNode.setLeftTreeNode(node);

        //重算节点的高度
        node.setHeight(Math.max(getTreeNodeHeight(node.getLeftTreeNode()),
                getTreeNodeHeight(node.getRightTreeNode())) + 1);
        rotateNode.setHeight(Math.max(getTreeNodeHeight(rotateNode.getLeftTreeNode()), node.getHeight()) + 1);

        return rotateNode;
    }

    /**
     * 左子节点双旋转
     * 1、node的左子节点左旋
     * 2、node右旋
     *
     * @param node
     * @return
     */
    private TreeNode doubleRotateWithLeftChild(TreeNode node) {
        TreeNode rotatedNode = rotateWithRightChild(node.getLeftTreeNode());
        node.setLeftTreeNode(rotatedNode);
        return rotateWithLeftChild(node);
    }

    /**
     * 双旋转
     * 1、node右子节点的左子树，先往右旋转
     * 2、node左旋
     *
     * @param node
     * @return
     */
    private TreeNode doubleRotateWithRightChild(TreeNode node) {
        TreeNode rotatedNode = rotateWithLeftChild(node.getRightTreeNode());
        node.setRightTreeNode(rotatedNode);
        return rotateWithRightChild(node);
    }

    public void createBinarySearchTree(int[] array) {
        for (int value : array) {
            TreeNode node = new TreeNode();
            node.setId(value);
            node.setValue(value);
            addTreeNode(node);
        }
    }

    public void addTreeNode(TreeNode node) {
        if (root == null) {
            root = node;
        } else {
            root.addNode(node);
        }
    }

    public TreeNode findMinTreeNode(TreeNode treeNode) {
        if (treeNode == null) {
            return null;
        }
        if (treeNode.getLeftTreeNode() == null) {
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

        return balance(node);
    }

}
