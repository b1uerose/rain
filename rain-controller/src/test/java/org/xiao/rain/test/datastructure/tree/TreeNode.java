package org.xiao.rain.test.datastructure.tree;

import java.io.Serializable;

/**
 * 树的节点
 * Author: xiaojl
 * Date: 2021/12/5 16:58
 */
public class TreeNode implements Cloneable, Serializable, Comparable<TreeNode> {
    private static final long serialVersionUID = 4956646767654009244L;
    private int id;
    private String name;
    private TreeNode leftTreeNode;
    private TreeNode rightTreeNode;
    private char character; //huffmantree的编码
    private String path; //huffman 编码路径
    private byte byteValue;//
    private int weighted;//权值
    private int value; //二叉搜索树的值
    private int height; //节点高度

    //根据不同的遍历方式(中序，前序，后续遍历)，前驱和后继节点不一样
    private int leftNodeType; //0=左子树，1=前驱节点 
    private int rightNodeType; //0=右字数，1=后继节点

    public TreeNode(int id, char character) {
        this.id = id;
        this.character = character;
    }

    public TreeNode(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public TreeNode(int id, byte byteValue, int weighted) {
        this.id = id;
        this.byteValue = byteValue;
        this.weighted = weighted;
    }

    public TreeNode(int id, int value) {
        this.id = id;
        this.value = value;
    }

    public TreeNode() {
    }

    public String getPath() {
        return path;
    }

    public void setPath(String path) {
        this.path = path;
    }

    public char getCharacter() {
        return character;
    }

    public void setCharacter(char character) {
        this.character = character;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public TreeNode getLeftTreeNode() {
        return leftTreeNode;
    }

    public void setLeftTreeNode(TreeNode leftTreeNode) {
        this.leftTreeNode = leftTreeNode;
    }

    public TreeNode getRightTreeNode() {
        return rightTreeNode;
    }

    public void setRightTreeNode(TreeNode rightTreeNode) {
        this.rightTreeNode = rightTreeNode;
    }

    public int getLeftNodeType() {
        return leftNodeType;
    }

    public void setLeftNodeType(int leftNodeType) {
        this.leftNodeType = leftNodeType;
    }

    public int getRightNodeType() {
        return rightNodeType;
    }

    public void setRightNodeType(int rightNodeType) {
        this.rightNodeType = rightNodeType;
    }

    public byte getByteValue() {
        return byteValue;
    }

    public void setByteValue(byte byteValue) {
        this.byteValue = byteValue;
    }

    public int getWeighted() {
        return weighted;
    }

    public void setWeighted(int weighted) {
        this.weighted = weighted;
    }

    public int getValue() {
        return value;
    }

    public void setValue(int value) {
        this.value = value;
    }

    @Override
    public String toString() {
        return "TreeNode{" +
                "id=" + id +
                ", value='" + value + '\'' +
                '}';
    }

    @Override
    public int compareTo(TreeNode node) {
        return this.getId() - node.getId();
    }

    public void addNode(TreeNode node) {
        if (node == null) {
            return;
        }

        if (this.getValue() > node.getValue()) {
            if (this.getLeftTreeNode() == null) {
                this.setLeftTreeNode(node);
            } else {
                this.getLeftTreeNode().addNode(node);
            }
        } else {
            if (this.getRightTreeNode() == null) {
                this.setRightTreeNode(node);
            } else {
                this.getRightTreeNode().addNode(node);
            }
        }
    }

    public int getHeight() {
        return height;
    }

    public void setHeight(int height) {
        this.height = height;
    }

    //已当前节点为根节点的树的高度
    public int height() {
        return Math.max(getLeftTreeNode() == null ? 0 : getLeftTreeNode().height(), 
                getRightTreeNode() == null ? 0 : getRightTreeNode().height()) + 1;
    }
    
    public int getLeftTreeNodeHeight() {
        return getLeftTreeNode() == null ? 0 : getLeftTreeNode().height();
    }
    
    public int getRightTreeNodeHeight() {
        return getRightTreeNode() == null ? 0 : getRightTreeNode().height();
    }
}
