package com.zhuangzhao.leetcode.three.two.two;

class Solution {
    public int coinChange(int[] coins, int amount) {
        int[] count = new int[amount + 1];
        count[0] = 0;
        for (int i = 1; i <= amount; i++) {
            int min = Integer.MAX_VALUE;
            for (int coin : coins) {
                if (i - coin >= 0 && count[i - coin] >= 0) {
                    if (count[i - coin] < min) {
                        min = count[i - coin];
                    }
                }
            }
            if (min == Integer.MAX_VALUE) {
                count[i] = -1;
            } else {
                count[i] = min + 1;
            }
        }
        return count[amount];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] coins = {1, 2, 5};
        System.out.println(solution.coinChange(coins, 11));
    }
}