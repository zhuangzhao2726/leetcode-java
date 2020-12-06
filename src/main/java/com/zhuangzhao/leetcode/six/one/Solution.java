package com.zhuangzhao.leetcode.six.one;


class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        int length = 0;
        ListNode p = head;
        ListNode tail = head;
        while (p != null)  {
            length++;
            tail = p;
            p = p.next;
        }
        if (length == 0) {
            return head;
        }
        k = k % length;
        k = length - k;
        k = k % length;
        if (k == 0) {
            return head;
        }
        ListNode next = head;
        for (int i = 1; i < k; i++) {
            next = next.next;
        }
        tail.next = head;
        ListNode newHead = next.next;
        next.next = null;
        return newHead;
    }


    public static void main(String[] args) {
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4, null))));
        Solution solution = new Solution();
        head = solution.rotateRight(head, 1);
        while (head != null) {
            System.out.println(head.val);
            head = head.next;
        }
    }
}


class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }

    public ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}