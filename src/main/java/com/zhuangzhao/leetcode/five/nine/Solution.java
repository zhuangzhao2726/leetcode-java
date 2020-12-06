package com.zhuangzhao.leetcode.five.nine;

class Solution {
    public int[][] generateMatrix(int n) {
        int[][] result = new int[n][n];
        int index = 1;
        int j = 0;
        for (int i = 0; i + i < n; i++) {
            for (j = i; j <= n - 1 - i; j++)
                result[i][j] = index++;
            for (j = i + 1; j <= n - 1 - i; j++)
                result[j][n - 1 - i] = index++;
            if (n >> 1 > i) {
                for (j = n - 2 - i; j >= i; j--)
                    result[n - 1 - i][j] = index++;
                for (j = n - 2 - i; j > i; j--) {
                    result[j][i] = index++;
                }
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = solution.generateMatrix(4);
        solution.print(matrix);
    }

    private void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int num : matrix[i]) {
                System.out.print(num + "  ");
            }
            System.out.println();
        }
    }
}