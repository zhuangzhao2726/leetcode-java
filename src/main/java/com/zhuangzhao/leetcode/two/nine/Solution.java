package com.zhuangzhao.leetcode.two.nine;

class Solution {
    public int divide(int dividend, int divisor) {
        int value = 0;
        if (dividend < 0) {
            if (divisor < 0) {
                while (dividend <= divisor) {
                    if (value < Integer.MAX_VALUE) {
                        value++;
                    }
                    dividend = dividend - divisor;
                }
            } else {
                while (dividend + divisor <= 0) {
                    value--;
                    dividend = dividend + divisor;
                }
            }
        } else {
            if (divisor > 0) {
                while (dividend - divisor >= 0) {
                    value++;
                    dividend = dividend - divisor;
                }
            } else {
                while (dividend + divisor >= 0) {
                    value--;
                    dividend = dividend + divisor;
                }
            }
        }
        return value;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.divide(10, 3));
    }
}