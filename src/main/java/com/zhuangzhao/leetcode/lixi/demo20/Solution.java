package com.zhuangzhao.leetcode.lixi.demo20;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {
        if (s == null || "".equals(s)) {
            return true;
        }
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < s.length(); i++) {
            Character character = s.charAt(i);
            if ('(' == character || '[' == character || '{' == character) {
                stack.push(character);
            } else if (stack.isEmpty()) {
                return false;
            } else if (character - stack.peek() <= 2) {
                stack.pop();
            } else {
                return false;
            }
        }
        return stack.isEmpty();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("())()()()"));
        System.out.println(solution.isValid("){()}"));
        System.out.println(solution.isValid("}}[[))((((("));
        System.out.println(solution.isValid("}}[[))((((("));
        System.out.println(solution.isValid("}}[[))((((("));
        System.out.println(solution.isValid("}}[[))((((("));
        System.out.println(solution.isValid("}}[[))((((("));

    }
}