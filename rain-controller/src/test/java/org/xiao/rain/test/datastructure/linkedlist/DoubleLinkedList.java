package org.xiao.rain.test.datastructure.linkedlist;

import lombok.extern.slf4j.Slf4j;

/**
 * 双向链表
 * Author: xiaojl
 * Date: 2021/11/4 22:40
 */
@Slf4j
public class DoubleLinkedList {
    
    Node header;
    
    public DoubleLinkedList() {
        header = new Node();
    }
    
    public void addNode(Node newNode) {
        Node lastNode = header;
        while(lastNode.getNext() != null) {
            lastNode = lastNode.getNext();
        }
        lastNode.setNext(newNode);
        newNode.setPre(lastNode);
    } 
    
    public void addNodeAsc(Node newNode) {
        Node firstNode = header;
        Node secondNode = header.getNext();
        while(true) {
            if(secondNode == null) {
                firstNode.setNext(newNode);
                newNode.setPre(firstNode);
                break;
            }
            if(secondNode.getNo() >= newNode.getNo()) {
                firstNode.setNext(newNode);
                newNode.setPre(firstNode);
                newNode.setNext(secondNode);
                secondNode.setPre(newNode);
                break;
            }
            if(secondNode.getNo() < newNode.getNo()) {
                firstNode = secondNode;
                secondNode = secondNode.getNext();
                continue;
            }
        }
    }
    
    public void deleteNodeByNo(int no) {
        Node node = header.getNext();
        while (node != null) {
            
            if(node.getNo() == no) {
                node.getPre().setNext(node.getNext());
                if(node.getNext() != null) {
                    node.getNext().setPre(node.getPre());
                }
                break;
            }
            node = node.getNext();
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

    public static void main(String[] args) {
        
        DoubleLinkedList list = new DoubleLinkedList();
        list.addNodeAsc(new Node(3, "肖金龙", "xiaojl"));
        list.addNodeAsc(new Node(1, "孙璐", "sunl"));
        list.addNodeAsc(new Node(2, "肖雨桐", "xiaoyt"));
        
        list.showList();
        list.deleteNodeByNo(3);
        list.showList();
    }
    
    
}
