package com.zhuangzhao.leetcode.one.two.one;

class Solution {
    public int maxProfit(int[] prices) {
        int max = 0;
        int count = prices.length > 0 ? prices[0] : 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] >= count) {
                max = max > (prices[i] - count) ? max : (prices[i] - count);
            } else {
                count = prices[i];
            }
        }
        return max;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] prices = {7, 6, 4, 3, 1};
        System.out.println(solution.maxProfit(prices));
    }
}