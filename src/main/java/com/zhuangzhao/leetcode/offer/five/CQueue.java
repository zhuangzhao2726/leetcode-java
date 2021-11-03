package com.zhuangzhao.leetcode.offer.five;

import java.util.Stack;

class CQueue {

    Stack<Integer> stack1;

    Stack<Integer> stack2;

    public CQueue() {
        stack1 = new Stack<>();
        stack2 = new Stack<>();

    }

    public void appendTail(int value) {
        stack2.push(value);
    }

    public int deleteHead() {
        if (stack1.empty()) {
            while (!stack2.empty()) {
                stack1.push(stack2.pop());
            }
        }
        if (!stack1.empty()) {
            return stack1.pop();
        } else {
            return -1;
        }
    }
}