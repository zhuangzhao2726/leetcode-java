package com.zhuangzhao.leetcode.interview_internal_reference.one;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2020-10-04 20:23
 */
public class Solution {

    public Node reverse(Node head) {
        if (head == null) {
            return head;
        }

        Node left = null;
        Node p = head;
        Node next = head.next;
        while (p != null) {
            p.next = left;
            left = p;
            p = next;
            if (next != null) {
                next = next.next;
            }
        }
        return left;
    }

    public static void main(String[] args) {
        Node head = new Node(1, new Node(2, new Node(3, new Node(4, new Node(5)))));
        Solution solution = new Solution();
        head = solution.reverse(head);
        System.out.println(head);
    }


}

class Node {
    int val;
    Node next;

    public Node(int val) {
        this.val = val;
    }

    public Node(int val, Node next) {
        this.val = val;
        this.next = next;
    }
}
