package com.zhuangzhao.leetcode.lixi.linetooffer;

import java.util.LinkedList;
import java.util.Queue;

class MyStack {

    Queue<Integer> queue1;
    Queue<Integer> queue2;
    int top;

    /**
     * Initialize your data structure here.
     */
    public MyStack() {
        queue1 = new LinkedList<>();
        queue2 = new LinkedList<>();
    }

    /**
     * Push element x onto stack.
     */
    public void push(int x) {
        queue1.add(x);
        top = x;
        class Solution {
            public void nextPermutation(int[] nums) {

            }
        }
    }

    /**
     * Removes the element on top of the stack and returns that element.
     */
    public int pop() {
        if (queue1.isEmpty()) {
            return -1;
        }
        if (queue1.size() == 1) {
            return queue1.remove();
        }

        while (queue1.size() > 1) {
            top = queue1.remove();
            queue2.add(top);
        }
        Integer num = queue1.remove();
        Queue<Integer> queue;
        queue = queue2;
        queue2 = queue1;
        queue1 = queue;

        //while(queue2.isEmpty()){
        //  queue1.add(queue2.remove());
        //}

        return num;
    }

    /**
     * Get the top element.
     */
    public int top() {
        if (queue1.isEmpty()) {
            return -1;
        }
        return top;
    }

    /**
     * Returns whether the stack is empty.
     */
    public boolean empty() {
        return queue1.isEmpty();
    }
}

/**
 * Your MyStack object will be instantiated and called as such:
 * MyStack obj = new MyStack();
 * obj.push(x);
 * int param_2 = obj.pop();
 * int param_3 = obj.top();
 * boolean param_4 = obj.empty();
 */