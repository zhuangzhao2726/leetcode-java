package com.zhuangzhao.leetcode.three.two;

import java.util.Stack;

class Solution {
    public int longestValidParentheses(String s) {

        int[] array = new int[s.length()];

        for (int i = 1; i < s.length(); i++) {
            if (s.charAt(i - 1) == '(' && s.charAt(i) == ')') {
                if (i - 2 >= 0) {
                    array[i] = array[i - 2] + 2;
                } else {
                    array[i] = 2;
                }
            } else {
                int left = i - array[i - 1] - 1;
                if (left >= 0 && s.charAt(left) == '(' && s.charAt(i) == ')') {
                    if (left > 0) {
                        array[i] = array[left - 1] + array[i - 1] + 2;
                    } else {
                        array[i] = array[i - 1] + 2;
                    }
                }
            }
        }
        int max = 0;
        for (int i = 0; i < s.length(); i++) {
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.longestValidParentheses("()(())"));
    }
}