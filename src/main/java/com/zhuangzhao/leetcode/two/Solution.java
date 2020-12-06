package com.zhuangzhao.leetcode.two;

/**
 * Definition for singly-linked list.
 */
class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode addTwoNumbers(ListNode l1, ListNode l2) {

        ListNode head = new ListNode(0);
        head.next = null;


        ListNode list1 = l1;
        ListNode list2 = l2;
        int add = 0;

        ListNode p = head;
        while (list1!= null || list2 != null || add != 0) {

            if(list1 != null && list2 != null) {
                ListNode node = new ListNode((list1.val + list2.val + add) % 10);
                node.next = null;
                add = (list1.val + list2.val + add) / 10;
                p.next = node;
                p = p.next;
                list1 = list1.next;
                list2 = list2.next;
            } else if(list1 != null) {
                ListNode node = new ListNode((list1.val + add) % 10);
                add = (list1.val + add) / 10;
                p.next = node;
                p = p.next;
                list1 = list1.next;
            } else if(list2 != null) {
                ListNode node = new ListNode((list2.val + add) % 10);
                add = (list2.val + add) / 10;
                p.next = node;
                p = p.next;
                list2 = list2.next;
            } else {
                ListNode node = new ListNode(add % 10);
                node.next = null;
                add = add / 10;
                p.next = node;
                p = p.next;
            }
        }
        return head.next;
    }
}