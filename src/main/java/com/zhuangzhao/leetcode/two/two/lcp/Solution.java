package com.zhuangzhao.leetcode.two.two.lcp;

class Solution {
    public int paintingPlan(int n, int k) {
        if (k == n * n) {
            return 1;
        } else {
            int total = 0;
            for (int i = 0; i < n; i++) {
                if (k < n * i) {
                    break;
                } else if ((k - n * i) % (n - i) == 0) {
                    int j = (k - n * i) / (n - i);
                    total += f(n, i) * f(n, j);
                }
            }
            return total;
        }
    }

    public int f(int n, int index) {
        int total = 1;
        for (int i = n; i > n - index; i--) {
            total *= i;
        }
        for (int i = 1; i <= index; i++) {
            total /= i;
        }
        return total;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.f(5,2));
        System.out.println(solution.paintingPlan(2,4));
        System.out.println(solution.paintingPlan(2,3));
    }
}