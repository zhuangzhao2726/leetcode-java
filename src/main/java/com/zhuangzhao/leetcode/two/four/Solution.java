package com.zhuangzhao.leetcode.two.four;


import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}


class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode first = head;
        ListNode second = head;
        while (first != null && first.next != null) {
            second = first.next;
            int value = first.val;
            first.val = second.val;
            second.val = value;
            first = second.next;
        }
        return head;
    }
}