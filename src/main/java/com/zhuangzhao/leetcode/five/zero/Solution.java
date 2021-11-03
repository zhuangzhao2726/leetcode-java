package com.zhuangzhao.leetcode.five.zero;

class Solution {
    public double myPow(double x, int n) {
        return n >= 0 ? myPow1(x, n) : 1 / myPow1(x, -n);
    }

    private double myPow1(double x, int n) {
        if (n == 0) {
            return 1;
        }
        if (n == 1) {
            return x;
        } else {
            double value = myPow1(x, n / 2);
            if ((n & 1) == 1) {
                return value * value * x;
            } else {
                return value * value;
            }
        }
    }
}