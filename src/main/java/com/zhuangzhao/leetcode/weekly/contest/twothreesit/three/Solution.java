package com.zhuangzhao.leetcode.weekly.contest.twothreesit.three;

import java.util.Arrays;

class Solution {
    public int minSideJumps(int[] obstacles) {
        int[][] dp = new int[obstacles.length][3];
        dp[0][1] = 0;
        if (obstacles[0] == 0) {
            dp[0][0] = dp[0][1] + 1;
            dp[0][2] = dp[0][1] + 1;
        } else if (obstacles[0] == 1){
            dp[0][0] = -1;
            dp[0][2] = dp[0][1] + 1;
        } else {
            dp[0][0] = dp[0][1] + 1;
            dp[0][2] = -1;
        }
        for (int i = 1; i < obstacles.length; i++) {
            int min = Integer.MAX_VALUE;
            for (int j = 0; j < 3; j++) {
                if (obstacles[i] == j + 1) {
                    dp[i][j] = -1;
                } else if (obstacles[i - 1] != j + 1) {
                    dp[i][j] = dp[i - 1][j] + 1;
                    if (dp[i][j] < min) {
                        min = dp[i][j];
                    }
                }
            }
            if (obstacles[i - 1] != obstacles[i] && obstacles[i - 1] > 0) {
                dp[i][obstacles[i - 1] - 1] = min + 1;
            }
        }
        return min(dp[obstacles.length - 1]);
    }

    private int min(int[] array) {
        int min = Integer.MAX_VALUE;
        for (int num : array) {
            if (num >= 0 && num < min) {
                min = num;
            }
        }
        return min;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] obstacles = {0,1,1,3,3,0};
        System.out.println(solution.minSideJumps(obstacles) - (obstacles.length - 1));
    }
}