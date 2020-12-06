package com.zhuangzhao.leetcode.weekly.contest.onesixfive.three;

class Solution {
    public int countSquares(int[][] matrix) {

        int count = 0;

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                for (int length = 1; length <= matrix.length; length++) {
                    if(isAllOne(matrix, i, j, length)) {
                        count++;
                    }
                }
            }
        }
        return count;
    }

    public boolean isAllOne(int[][] matrix, int row, int col, int length) {
        if(row + length > matrix.length || col + length > matrix[0].length) {
            return false;
        }

        for (int i =0; i < length; i++) {
            for (int j = 0; j < length; j++) {
                if (matrix[row + i][col + j] != 1) {
                    return false;
                }
            }
        }
        return true;
    }
}