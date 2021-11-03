package com.zhuangzhao.leetcode.one.four.three;

import java.util.ArrayList;
import java.util.List;

class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}



class Solution {
    public void reorderList(ListNode head) {
        List<ListNode> listNodes = new ArrayList<>();
        ListNode p = head;
        while (p != null) {
            listNodes.add(p);
            p = p.next;
        }
        if (listNodes.size() <= 2) {
            return;
        }
        ListNode q = head;
        int i = 1;
        int j = listNodes.size() - 1;
        while (i <= j) {
            q.next = listNodes.get(j--);
            q = q.next;
            if (i <= j) {
                q.next = listNodes.get(i++);
                q = q.next;
            }
        }
        q.next = null;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        ListNode head = new ListNode(1, new ListNode(2, new ListNode(3, new ListNode(4))));
        solution.reorderList(head);
        System.out.println(head);
    }
}