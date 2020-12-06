package com.zhuangzhao.leetcode.one.nine;

class Solution {
    public ListNode removeNthFromEnd(ListNode head, int n) {
        ListNode first = head;
        ListNode second = head;
        int i = 1;
        for (; i < n; i++) {
            if (first != null) {
                first = first.next;
            } else {
                break;
            }
        }

        if (i < n) {
            return head;
        }
        if (first.next == null) {
            head =  head.next;
        } else {
            first = first.next;
            while (first.next != null) {
                first = first.next;
                second = second.next;
            }
            second.next = second.next.next;
        }
        return head;
    }

    public static void main(String[] args) {
        ListNode listNode1 = new ListNode(1);
        ListNode listNode2 = new ListNode(2);
        listNode1.next = listNode2;
        ListNode listNode3 = new ListNode(3);
        listNode2.next = listNode3;
        ListNode listNode4 = new ListNode(4);
        listNode3.next = listNode4;
        ListNode listNode5 = new ListNode(5);
        listNode4.next = listNode5;

        Solution solution = new Solution();
        ListNode p = solution.removeNthFromEnd(listNode1, 2);
        while (p != null) {
            System.out.println(p.val);
            p = p.next;
        }
    }
}



class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}
