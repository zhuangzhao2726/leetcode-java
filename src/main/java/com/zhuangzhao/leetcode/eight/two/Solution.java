package com.zhuangzhao.leetcode.eight.two;


class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}

class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        ListNode newHead = null;
        ListNode x = null;
        ListNode p = head;
        while (p != null) {
            ListNode q = p.next;
            boolean flag = true;
            while (q != null && p.val == q.val) {
                flag = false;
                q = q.next;
            }
            if (flag) {
                if (x == null) {
                    x = p;
                    newHead = x;
                } else {
                    x.next = p;
                    x = x.next;
                }
                p = p.next;
                x.next = null;
            } else {
                p = q;
            }
        }
        return newHead;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(3, new ListNode(4, new ListNode(4, new ListNode(5)))))));
        head = solution.deleteDuplicates(head);
        System.out.println(head);
    }
}