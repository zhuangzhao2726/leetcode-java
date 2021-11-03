package com.zhuangzhao.leetcode.six.two;

class Solution {
    public int uniquePaths(int m, int n) {
        if (m <= 1 || n <= 1) {
            return 1;
        }
        int step = m + n - 2;
        return (int) zuheshu(step, m - 1 < n - 1 ? m - 1 : n - 1);
    }

    private long zuheshu(int m, int n) {
        long count = 1;
        for (int i = 1; i <= n; i++) {
            count *= (m + 1 - i);
            count /= i;
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.uniquePaths(59, 5));
    }
}