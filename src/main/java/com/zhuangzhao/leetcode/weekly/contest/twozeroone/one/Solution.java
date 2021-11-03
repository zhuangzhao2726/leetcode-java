package com.zhuangzhao.leetcode.weekly.contest.twozeroone.one;

import java.util.Stack;

class Solution {
    public String makeGood(String s) {

        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            char charAt = s.charAt(i);
            if (stack.empty()) {
                stack.push(charAt);
            } else if (stack.peek() == (char) (charAt + 32) || stack.peek() == (char) (charAt - 32)) {
                stack.pop();
            } else {
                stack.push(charAt);
            }
        }

        StringBuilder stringBuilder = new StringBuilder();
        while (!stack.empty()) {
            Character character = stack.pop();
            stringBuilder = new StringBuilder(String.valueOf(character)).append(stringBuilder);
        }
        return stringBuilder.toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.makeGood("leEeetcode"));
    }
}