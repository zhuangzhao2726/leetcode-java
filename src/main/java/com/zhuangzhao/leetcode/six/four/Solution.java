package com.zhuangzhao.leetcode.six.four;

class Solution {
    public int minPathSum(int[][] grid) {
        int[] dp = new int[grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[i].length; j++) {
                if (i == 0 && j == 0) {
                    dp[j] = grid[i][j];
                } else if (i == 0) {
                    dp[j] = dp[j - 1] + grid[i][j];
                } else if (j == 0) {
                    dp[j] = dp[j] + grid[i][j];
                } else {
                    int min = dp[j - 1] < dp[j] ? dp[j - 1] : dp[j];
                    dp[j] = min + grid[i][j];
                }
            }
        }
        return dp[grid[0].length - 1];
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        System.out.println(solution.minPathSum(grid));
    }
}