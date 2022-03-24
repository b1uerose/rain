package org.xiao.rain.test.datastructure.linkedlist;

import lombok.extern.slf4j.Slf4j;
import org.junit.Test;

import java.util.ArrayList;
import java.util.List;

/**
 * 约瑟夫环
 * Author: xiaojl
 * Date: 2021/11/5 22:23
 */
@Slf4j
public class JosephuCircle {

    private static int personNum = 5;

    public static void main(String[] args) {
        //1、构造一个环形链表
        List<Node> nodelist = new ArrayList<>();
        Node firstNode = null;
        Node preNode = null;
        for (int i = 0; i < personNum; i++) {
            Node newNode = new Node(i + 1, "人物" + (i + 1), "person" + (i + 1));
            if (i == 0) {
                firstNode = newNode;
            }
            if (preNode != null) {
                preNode.setNext(newNode);
            }
            preNode = newNode;
            if (i == personNum - 1) {
                newNode.setNext(firstNode);
            }
            nodelist.add(newNode);
        }

        //2、
//        int number = new Random().ints(1, 11).findFirst().getAsInt();
        int number = 1;
        log.debug("从第{}个人开始", number);
//        int countTime = new Random().ints(1, 11).findFirst().getAsInt();
        int countTime = 2;
        log.debug("数{}下", countTime);

        Node node = firstNode;
//        for (int i = 0; i < number; i++) {
//            node = node.getNext();
//        }

        log.debug("从{}开始开始", node);
        List<Node> list = new ArrayList<Node>();
        Node prenode = null;
        while (prenode != node) {
            for (int i = 0; i < countTime; i++) {
                if (i == countTime - 2) {
                    prenode = node;
                }

                if (i == countTime - 1) {
                    list.add(node);
                }

                node = node.getNext();
            }
            prenode.setNext(node);
        }
        list.add(node);

        for (Node node1 : list) {
            log.debug(node1.toString());
        }
    }

    @Test
    public void createCircleLinkedList() {
        int num = 5;
        List<Node> nodelist = new ArrayList<>();
        Node firstNode = new Node(1, "1", "1");
        nodelist.add(firstNode);
        Node preNode = firstNode;
        for (int i = 1; i < num; i++) {
            Node node = new Node(i + 1, "" + (i + 1), "" + (i + 1));
            nodelist.add(node);
            preNode.setNext(node);
            node.setNext(firstNode);
            preNode = node;
        }

        int countTime = 2;
        
        Node helper = firstNode;
        Node first = firstNode;
        do {
            helper = helper.getNext();
        } while (helper.getNext() != firstNode);
        
        while (helper != first) {

            for (int i = 0; i < countTime-1; i++) {
                first = first.getNext();
                helper = helper.getNext();
            }
            helper.setNext(first.getNext());
            log.debug(first.toString());
            first = first.getNext();
        }
        
        log.debug(first.toString());
        
    }

}
