package org.xiao.rain.test.datastructure.linkedlist;

import java.io.Serializable;

/**
 * Author: xiaojl
 * Date: 2021/11/3 00:10
 */
public class Node implements Serializable {

    private static final long serialVersionUID = 5948148315400446095L;
    
    private Node next;
    private Node pre;
    private int no;
    private String name;
    private String nickName;

    public Node() {
    }

    public Node(int no, String name, String nickName) {
        this.no = no;
        this.name = name;
        this.nickName = nickName;
    }

    public Node getPre() {
        return pre;
    }

    public void setPre(Node pre) {
        this.pre = pre;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }

    public int getNo() {
        return no;
    }

    public void setNo(int no) {
        this.no = no;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getNickName() {
        return nickName;
    }

    public void setNickName(String nickName) {
        this.nickName = nickName;
    }

    @Override
    public String toString() {
        return "Node{" +
                "no=" + no +
                ", name='" + name + '\'' +
                ", nickName='" + nickName + '\'' +
                '}';
    }
}
