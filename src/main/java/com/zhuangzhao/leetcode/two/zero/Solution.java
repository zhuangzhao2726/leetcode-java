package com.zhuangzhao.leetcode.two.zero;

import java.util.Stack;

class Solution {
    public boolean isValid(String s) {


        Stack<Character> stack = new Stack<>();

        boolean flag = true;
        for (int i = 0; i < s.length(); i++) {
            switch (s.charAt(i)) {
                case '(':
                case '[':
                case '{':
                    stack.push(s.charAt(i));
                    break;
                case ')':
                    if (!stack.empty() && stack.peek() == '(') {
                        stack.pop();
                    } else {
                        flag = false;
                    }
                    break;
                case ']':
                    if (!stack.empty() && stack.peek() == '[') {
                        stack.pop();
                    } else {
                        flag = false;
                    }
                    break;
                case '}':
                    if (!stack.empty() && stack.peek() == '{') {
                        stack.pop();
                    } else {
                        flag = false;
                    }
                    break;
                default:
                    break;
            }
            if (!flag) {
                break;
            }
        }
        return flag && stack.empty();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isValid("()"));
        System.out.println(solution.isValid("()[]{}"));
        System.out.println(solution.isValid("(]"));
        System.out.println(solution.isValid("([)]"));
        System.out.println(solution.isValid("{[]}"));
    }
}