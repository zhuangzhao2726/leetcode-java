package com.zhuangzhao.leetcode.two.three;


import java.util.List;

class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


class Solution {
    public ListNode mergeKLists(ListNode[] lists) {
        ListNode[] p = lists;

        ListNode head = null;
        ListNode q = null;

        while (true) {
            int min = -1;
            for (int i = 0; i < p.length; i++) {
                if (p[i] != null && (min == -1 || p[i].val < p[min].val)) {
                    min = i;
                }
            }
            if (min == -1) {
                return head;
            } else {
                if (head == null) {
                    head = p[min];
                    q = head;
                    p[min] = p[min].next;
                } else {
                    q.next = p[min];
                    q = q.next;
                    p[min] = p[min].next;
                }
            }
        }
    }
}