package com.zhuangzhao.leetcode.weekly.contest.twooneeight.three;

class Solution {
    public int concatenatedBinary(int n) {
        long ans = 1;
        for (int i = 2; i <= n; i++) {
            int length = this.bitOfNum(i);
            ans <<= length;
            ans += i;
            ans %= 1000000007;
        }
        return (int) ans;
    }

    private int bitOfNum(int num) {
        int i = 0;
        while (num >=1) {
            num >>= 1;
            i++;
        }
        return i;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.concatenatedBinary(12));
    }
}