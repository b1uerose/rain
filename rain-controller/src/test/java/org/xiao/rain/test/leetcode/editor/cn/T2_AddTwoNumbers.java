package org.xiao.rain.test.leetcode.editor.cn;

/**
 * 两数相加
 * Author: xiaojl
 * Date:2022-02-24 09:13:56
 */
public class T2_AddTwoNumbers {
    public static void main(String[] args) {
        Solution solution = new T2_AddTwoNumbers().new Solution();
//        [2,4,3]
//[5,6,4]
        ListNode l11 =  new T2_AddTwoNumbers().new ListNode(2);
        ListNode l12 =  new T2_AddTwoNumbers().new ListNode(4);
        ListNode l13 =  new T2_AddTwoNumbers().new ListNode(2);
        l11.next = l12;
        l12.next = l13;

        ListNode l21 =  new T2_AddTwoNumbers().new ListNode(5);
        ListNode l22 =  new T2_AddTwoNumbers().new ListNode(6);
        ListNode l23 =  new T2_AddTwoNumbers().new ListNode(4);
        l21.next = l22;
        l22.next = l23;

        solution.addTwoNumbers(l11, l21);
        // TO TEST
    }
    //leetcode submit region begin(Prohibit modification and deletion)

    class ListNode {
        int val;
        ListNode next;

        ListNode() {
        }

        ListNode(int val) {
            this.val = val;
        }

        ListNode(int val, ListNode next) {
            this.val = val;
            this.next = next;
        }
    }

    class Solution {
        public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
            
            if(l1 == null) {
                return l2;
            }
            
            if(l2 == null) {
                return l1;
            }
            
            int leftValue = 0;
            ListNode first = null;
            ListNode preNode = null;
            while (l1 != null || l2 != null) {
                int l1Value = getNodeValue(l1);
                int l2Value = getNodeValue(l2);
                
                int sum = l1Value + l2Value + leftValue;
                leftValue = sum / 10;
                int newNodeVal = sum % 10;
                ListNode newNode = new ListNode();
                newNode.val = newNodeVal;
                if (first == null) {
                    first = newNode;
                } else {
                    preNode.next = newNode;
                }
                preNode = newNode;
                
                if (l1 != null) {
                    l1 = l1.next;
                }
                if (l2 != null) {
                    l2 = l2.next;
                }
            }
            
            if (leftValue > 0) {
                preNode.next = new ListNode(leftValue);
            }
            
            return first;
        }
        
        public int getNodeValue(ListNode node) {
            if(node == null) {
                return 0;
            }
            
            return node.val;
        }
    }
//leetcode submit region end(Prohibit modification and deletion)

}


////////给你两个 非空 的链表，表示两个非负的整数。它们每位数字都是按照 逆序 的方式存储的，并且每个节点只能存储 一位 数字。 
////////
//////// 请你将两个数相加，并以相同形式返回一个表示和的链表。 
////////
//////// 你可以假设除了数字 0 之外，这两个数都不会以 0 开头。 
////////
//////// 
////////
//////// 示例 1： 
////////
//////// 
////////输入：l1 = [2,4,3], l2 = [5,6,4]
////////输出：[7,0,8]
////////解释：342 + 465 = 807.
//////// 
////////
//////// 示例 2： 
////////
//////// 
////////输入：l1 = [0], l2 = [0]
////////输出：[0]
//////// 
////////
//////// 示例 3： 
////////
//////// 
////////输入：l1 = [9,9,9,9,9,9,9], l2 = [9,9,9,9]
////////输出：[8,9,9,9,0,0,0,1]
//////// 
////////
//////// 
////////
//////// 提示： 
////////
//////// 
//////// 每个链表中的节点数在范围 [1, 100] 内 
//////// 0 <= Node.val <= 9 
//////// 题目数据保证列表表示的数字不含前导零 
//////// 
//////// Related Topics 递归 链表 数学 👍 7539 👎 0
//////
////
//
