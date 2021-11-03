package com.zhuangzhao.leetcode.interview_internal_reference.five;

import java.util.Optional;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2020-10-07 14:37
 */
public class Solution {


    public LinkNode removtKthNode(LinkNode head, int k) {
        LinkNode first = head;
        LinkNode second = head;
        for (int i = 1; i < k && first != null; i++) {
            first = first.next;
        }
        if (first == null) {
            return head;
        } else if (first.next == null) {
            return head.next;
        } else {
            first = first.next;
            while (first.next != null) {
                first = first.next;
                second = second.next;
            }
            second.next = second.next.next;
            return head;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        LinkNode head01 = new LinkNode(1, null);
        head01 = solution.removtKthNode(head01, 1);
        System.out.println(Optional.ofNullable(head01).map(LinkNode::getVal).orElse(-1));

        LinkNode head02 = new LinkNode(1, null);
        head02 = solution.removtKthNode(head02, 2);
        System.out.println(Optional.ofNullable(head02).map(LinkNode::getVal).orElse(-1));

        LinkNode head03 = new LinkNode(1, new LinkNode(2, null));
        head03 = solution.removtKthNode(head03, 1);
        System.out.println(Optional.ofNullable(head03).map(LinkNode::getVal).orElse(-1));

        LinkNode head04 = new LinkNode(1, new LinkNode(2, null));
        head04 = solution.removtKthNode(head04, 2);
        System.out.println(Optional.ofNullable(head04).map(LinkNode::getVal).orElse(-1));
    }
}


class LinkNode {
    int val;
    LinkNode next;

    public LinkNode(int val, LinkNode next) {
        this.val = val;
        this.next = next;
    }

    public int getVal() {
        return val;
    }
}