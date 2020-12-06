package com.zhuangzhao.leetcode.two.one;


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

class Solution {
    public ListNode mergeTwoLists(ListNode l1, ListNode l2) {

        ListNode head = null;
        ListNode p = null;

        ListNode first = l1;
        ListNode second = l2;

        while (first != null || second != null) {
            if (first == null) {
                if (head == null) {
                    head = second;
                    p = head;
                } else {
                    p.next = second;
                    p = p.next;
                }
                second = second.next;
            } else if (second == null) {
                if (head == null) {
                    head = first;
                    p = head;
                } else {
                    p.next = first;
                    p = p.next;
                }
                first = first.next;
            } else if (first.val <= second.val) {
                if (head == null) {
                    head = first;
                    p = head;
                } else {
                    p.next = first;
                    p = p.next;
                }
                first = first.next;
            } else {
                if (head == null) {
                    head = second;
                    p = head;
                } else {
                    p.next = second;
                    p = p.next;
                }
                second = second.next;
            }
        }
        return head;
    }



}