package com.zhuangzhao.leetcode.lixi.maxMoney;

public class Solution {
    public int getMaxMoney(int[][] matrix) {
        //1、特殊处理 2、遍历矩阵，求到每一个点的最优解 3、返回到目标点的最优解
        if (matrix == null || matrix.length == 0 || matrix[0].length == 0) {
            return 0;
        }

        int[][] dp = new int[matrix.length][matrix[0].length];
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                int max = 0;
                if (i == 0 && j == 0) {
                    max = 0;
                } else if (i == 0) {
                    max = dp[i][j - 1];
                } else if (j == 0) {
                    max = dp[i - 1][j];
                } else {
                    if (dp[i - 1][j] > dp[i][j - 1]) {
                        max = dp[i - 1][j];
                    } else {
                        max = dp[i][j - 1];
                    }
                }
                dp[i][j] = max + matrix[i][j];
            }
        }
        return dp[matrix.length - 1][matrix[0].length - 1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{7, 4, 3, 5, 6},
                {2, 4, 3, 6, 8},
                {0, 5, 4, 7, 4},
                {6, 8, 9, 7, 1},
                {4, 6, 8, 2, 4,}};
        int result = solution.getMaxMoney(matrix);
        System.out.println(result);

    }
}
