package com.zhuangzhao.leetcode.offer.three;


import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[] reversePrint(ListNode head) {
        List<Integer> list = new ArrayList<>();
        this.reverse(head, list);
        int[] nums = new int[list.size()];
        for (int i = 0; i < list.size(); i++) {
            nums[i] = list.get(i);
        }
        return nums;
    }

    private void reverse(ListNode node, List<Integer> list) {
        if (node == null) {
            return;
        }
        if (node.next != null) {
            reverse(node.next, list);
        }
        list.add(node.val);
    }



}





class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}