package org.xiao.rain.test.datastructure.linkedlist;

import lombok.extern.slf4j.Slf4j;

import java.util.Stack;

/**
 * 带有头节点的单向链表
 * Author: xiaojl
 * Date: 2021/11/3 00:11
 */
@Slf4j
public class LinkedList {
    
    Node header;
    
    public LinkedList() {
        header = new Node();
    }

    /**
     * 按add的先后顺序
     * @param node
     */
    public void add(Node node) {
        Node lastNode = header;
        while (lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
        }
        lastNode.setNext(node);
    }

    /**
     * 带排序的添加元素
     * @param node
     */
    public void addAndSort(Node node) {
        Node first = header;
        Node second = first.getNext();
        while (true) {
            if(second == null) {
                first.setNext(node);
                break;
            }
            if(second.getNo() < node.getNo()) {
                first = second;
                second = second.getNext();
                continue;
            } 
            if(second.getNo() == node.getNo()) {
                log.error("存在相同编号的节点，无法想队列添加数据！！！");
                break;
            }
            if(second.getNo() > node.getNo()) {
                first.setNext(node);
                node.setNext(second);
                break;
            }
        }
    }

    /**
     * 修改节点
     * @param newNode
     */
    public void modifyNode(Node newNode) {
        Node node = header;
        do {
            node = node.getNext();
        } while (node !=null && node.getNo() != newNode.getNo());

        if(node == null) {
            log.error("没有找到节点号为{}的节点", newNode.getNo());
            return;
        }
        
        node.setName(newNode.getName());
        node.setNickName(newNode.getNickName());
    }

    /**
     * 找到要删除元素的前一个元素
     * @param newNode
     */
    public void deleteNode(Node newNode) {
        Node node = header;
        while(node.getNext() != null) {
            Node next = node.getNext();
            if(next.getNo() == newNode.getNo()) {
                node.setNext(node.getNext().getNext());
                break;
            }
            node = next;
        }
    }
    
    public void showList() {
        Node nextNode = header.getNext();
        while (nextNode != null) {
            log.debug(nextNode.toString());
            nextNode = nextNode.getNext();
        }
        
        log.error("=====================================");
    }
    
    public int getListSize() {
        Node node = header.getNext();
        int count = 0;
        while(node != null) {
            count++;
            node = node.getNext();
        }
        return count;
    }

    /**
     * 获取倒数第几个链表的节点
     * @param n
     * @return
     */
    public Node getLastNNode(int n) {
        int size = getListSize();
        if(size<n) {
            log.error("链表的长度为：{}, 所以无法获取倒数第{}个node", size, n);
            return null;
        }
        
        int index = size - n;
        
        Node node = header.getNext();

        for (int i = 0; i < index; i++) {
            node = node.getNext();
        }
        return node;
    }
    
    public void reverseList() {
        Node firstNode = header.getNext();
        if(firstNode == null) {
            return;
        }
        Node secondNode = firstNode.getNext();
        firstNode.setNext(null);
        while (secondNode != null) {
            Node thirdNode = secondNode.getNext();
            secondNode.setNext(firstNode);
            firstNode = secondNode;
            secondNode = thirdNode;
        }
        header.setNext(firstNode);
    }
    
    public void reversePrint() {
        Node node = header.getNext();
        //利用栈，或者数组。先把数组放到数组中，然后倒叙遍历数组
        if(node == null) {
            log.error("链表为空，无法逆转打印");
        }
        Node[] arrays = new Node[getListSize()];
        
        int index = 0;
        
        while(node != null) {
            arrays[index++] = node;
            node = node.getNext();
        }

        for (int i = arrays.length-1; i >=0; i--) {
            log.debug(arrays[i].toString());
        }
    }
    
    public void reversePrintUseStack() {

        Node node = header.getNext();
        //利用栈，或者数组。先把数组放到数组中，然后倒叙遍历数组
        if(node == null) {
            log.error("链表为空，无法逆转打印");
        }

        Stack<Node> stack = new Stack<>();

        while(node != null) {
            stack.add(node);
            node = node.getNext();
        }
        
        while(!stack.empty()) {
            log.debug(stack.pop().toString());
        }
    }

    public static void main(String[] args) {
        LinkedList list = new LinkedList();
        //按顺序添加节点
        list.addAndSort(new Node(3, "肖雨桐", "xiaoyt"));
        list.addAndSort(new Node(2, "肖金龙", "xiaojl"));
        list.addAndSort(new Node(1, "孙璐", "sunl"));
        list.addAndSort(new Node(4, "xiaoxiao1", "xiaoxiao1"));
        list.addAndSort(new Node(5, "xiaoxiao2", "xiaoxiao2"));
        log.debug("链表长度为：{}", list.getListSize());
        list.showList();
        
        log.debug("翻转");
        list.reverseList();
        list.showList();

        //修改节点
        list.modifyNode(new Node(3, "小雨", "xiaoyu"));
        log.debug("链表长度为：{}", list.getListSize());
        list.showList();
        
        //删除节点
        list.deleteNode(new Node(3, "小雨", "xiaoyu"));
        log.debug("链表长度为：{}", list.getListSize());
        list.showList();
        
        //
        System.out.println("获取倒数第1个元素");
        log.debug("获取倒数第{}个元素{}", 1, list.getLastNNode(1));
        log.debug("获取倒数第{}个元素{}", 2, list.getLastNNode(2));
        log.debug("获取倒数第{}个元素{}", 3, list.getLastNNode(3));
        
        //倒转打印
        
//        list.reversePrint();
        
        list.reversePrintUseStack();
    }
}
