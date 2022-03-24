package org.xiao.rain.test.datastructure.tree.redblacktree;

/**
 * 红黑树节点
 * Author: xiaojl
 * Date: 2021/12/31 13:43
 */
public class RedBlackTreeNode<T extends Comparable<T>>{
    
    private RedBlackTreeNode<T> leftTreeNode;
    private RedBlackTreeNode<T> rightTreeNode;
    private RedBlackTreeNode<T> parentTreeNode;
    private Color color;
    private T value;

    public RedBlackTreeNode<T> getLeftTreeNode() {
        return leftTreeNode;
    }

    public void setLeftTreeNode(RedBlackTreeNode<T> leftTreeNode) {
        this.leftTreeNode = leftTreeNode;
    }

    public RedBlackTreeNode<T> getRightTreeNode() {
        return rightTreeNode;
    }

    public void setRightTreeNode(RedBlackTreeNode<T> rightTreeNode) {
        this.rightTreeNode = rightTreeNode;
    }

    public RedBlackTreeNode<T> getParentTreeNode() {
        return parentTreeNode;
    }

    public void setParentTreeNode(RedBlackTreeNode<T> parentTreeNode) {
        this.parentTreeNode = parentTreeNode;
    }

    public T getValue() {
        return value;
    }

    public void setValue(T value) {
        this.value = value;
    }

    public Color getColor() {
        return color;
    }

    public void setColor(Color color) {
        this.color = color;
    }

    public RedBlackTreeNode(RedBlackTreeNode<T> leftTreeNode, RedBlackTreeNode<T> rightTreeNode,
                            RedBlackTreeNode<T> parentTreeNode) {
        this.leftTreeNode = leftTreeNode;
        this.rightTreeNode = rightTreeNode;
        this.parentTreeNode = parentTreeNode;
    }

    public RedBlackTreeNode(RedBlackTreeNode<T> leftTreeNode, RedBlackTreeNode<T> rightTreeNode,
                            RedBlackTreeNode<T> parentTreeNode, Color color) {
        this.leftTreeNode = leftTreeNode;
        this.rightTreeNode = rightTreeNode;
        this.parentTreeNode = parentTreeNode;
        this.color = color;
    }

    public RedBlackTreeNode(RedBlackTreeNode<T> leftTreeNode, RedBlackTreeNode<T> rightTreeNode,
                            RedBlackTreeNode<T> parentTreeNode, Color color, T value) {
        this.leftTreeNode = leftTreeNode;
        this.rightTreeNode = rightTreeNode;
        this.parentTreeNode = parentTreeNode;
        this.color = color;
        this.value = value;
    }
}
