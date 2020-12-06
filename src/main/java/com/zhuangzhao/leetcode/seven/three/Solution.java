package com.zhuangzhao.leetcode.seven.three;

class Solution {
    public void setZeroes(int[][] matrix) {
        boolean firstCol = false;
        boolean firstRow = false;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                if (matrix[i][j] == 0) {
                    matrix[i][0] = 0;
                    matrix[0][j] = 0;
                    if (i == 0) {
                        firstRow = true;
                    }
                    if (j == 0) {
                        firstCol = true;
                    }
                }
            }
        }
        for (int i = matrix.length - 1; i >= 0; i++) {
            for (int j = matrix[i].length - 1; j >= 0; j--) {
                if (matrix[i][0] == 0 || matrix[0][j] == 0) {
                    matrix[i][j] = 0;
                }
            }
        }

        if (firstRow) {
            for (int i = 0; matrix.length > 0 && i < matrix[0].length; i++) {
                matrix[0][i] = 0;
            }
        }
        if (firstCol) {
            for (int i = 0; i < matrix.length && matrix[i].length > 0; i++) {
                matrix[i][0] = 0;
            }
        }
    }
}