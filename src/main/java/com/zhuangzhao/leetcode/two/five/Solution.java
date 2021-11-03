package com.zhuangzhao.leetcode.two.five;


class ListNode {
    int val;
    ListNode next;

    ListNode(int x) {
        val = x;
    }
}


class Solution {
    public ListNode reverseKGroup(ListNode head, int k) {
        ListNode[] p = new ListNode[k];
        ListNode q = head;

        while (true) {
            int i = 0;
            for (; i < k; i++) {
                if (q != null) {
                    p[i] = q;
                    q = q.next;
                } else {
                    break;
                }
            }
            if (i < k) {
                return head;
            } else {
                for (int j = 0; j < k / 2; j++) {
                    int value = p[j].val;
                    p[j].val = p[k - 1 - j].val;
                    p[k - 1 - j].val = value;
                }
            }
        }
    }
}