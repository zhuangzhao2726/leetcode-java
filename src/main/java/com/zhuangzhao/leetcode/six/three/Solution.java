package com.zhuangzhao.leetcode.six.three;

class Solution {
    public int uniquePathsWithObstacles(int[][] obstacleGrid) {
        int[] dp = new int[obstacleGrid[0].length];
        for (int i = 0; i < obstacleGrid.length; i++) {
            for (int j = 0; j < obstacleGrid[i].length; j++) {
                if (obstacleGrid[i][j] == 1) {
                    dp[j] = 0;
                } else if (i == 0 && j == 0) {
                    dp[j] = 1;
                } else if (i != 0 && j != 0) {
                    dp[j] = dp[j - 1] + dp[j];
                } else if (i == 0) {
                    dp[j] = dp[j - 1];
                } else {
                    dp[j] = dp[j];
                }
            }
        }
        return dp[obstacleGrid[0].length - 1];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] obstacleGrid = {
                {0, 0, 0},
                {0, 1, 0},
                {0, 0, 0}
        };
        System.out.println(solution.uniquePathsWithObstacles(obstacleGrid));
    }
}