package com.zhuangzhao.leetcode.two.two;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

class Solution {
    public List<String> generateParenthesis(int n) {
        Stack<Character> stack = new Stack<>();
        return generateParenthesis(n, stack, "");
    }


    public List<String> generateParenthesis(int n, Stack<Character> stack, String str) {
        List<String> list = new ArrayList<>();

        if (n == 0) {
            for (int i = 0; i < stack.size(); i++) {
                str += ")";
            }
            list.add(str);
        } else {
            if (stack.empty()) {
                stack.push('(');
                list.addAll(generateParenthesis(n - 1, stack, str + '('));
                stack.pop();
            } else {
                stack.push('(');
                list.addAll(generateParenthesis(n - 1, stack, str + '('));

                stack.pop();
                stack.pop();
                list.addAll(generateParenthesis(n, stack, str + ')'));
                stack.push('(');
            }
        }
        return list;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.generateParenthesis(3));
    }
}