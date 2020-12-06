package com.zhuangzhao.leetcode.offer.six;

class Solution {

    int MAX = 1000000007;

    public int fib(int n) {
        if (n <= 1) {
            return n;
        } else {
            int a = 1;
            int b = 1;
            for (int i = 2; i <= n; i++) {
                int tem = a + b;
                a = b % MAX;
                b = tem % MAX;
            }
            return b;
        }
    }
}