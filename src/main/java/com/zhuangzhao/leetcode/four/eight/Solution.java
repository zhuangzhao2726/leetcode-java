package com.zhuangzhao.leetcode.four.eight;

class Solution {
    public void rotate(int[][] matrix) {
        if ((matrix.length & 1) == 1) {
            rotate1(matrix);
        } else {
            rotate2(matrix);
        }
    }

    private void rotate2(int[][] matrix) {
        double center = (matrix.length - 1) / 2.0;

        for (double i = 0.5; i <= center; i += 1.0) {
            for (double j = 0.5; j <= center; j += 1.0) {
                int value = matrix[(int) (center - i)][(int) (center + j)];
                matrix[(int) (center - i)][(int) (center + j)] = matrix[(int) (center - j)][(int) (center - i)];
                matrix[(int) (center - j)][(int) (center - i)] = matrix[(int) (center + i)][(int) (center - j)];
                matrix[(int) (center + i)][(int) (center - j)] = matrix[(int) (center + j)][(int) (center + i)];
                matrix[(int) (center + j)][(int) (center + i)] = value;
            }
        }
    }

    private void rotate1(int[][] matrix) {
        int center = matrix.length >> 1;
        for (int i = 1; i <= center; i++) {
            for (int j = 0; j <= center; j++) {
                int value = matrix[center - i][center + j];
                matrix[center - i][center + j] = matrix[center - j][center - i];
                matrix[center - j][center - i] = matrix[center + i][center - j];
                matrix[center + i][center - j] = matrix[center + j][center + i];
                matrix[center + j][center + i] = value;
            }
        }
    }


    public static void main(String[] args) {
        int[][] matrix = {{1, 2, 3}, {4, 5, 6}, {7, 8, 9}};
        Solution solution = new Solution();
        solution.print(matrix);
        System.out.println("------------------");
        solution.rotate(matrix);
        solution.print(matrix);
        System.out.println("------------------");

        int[][] matrix01 = {{5, 1, 9, 11}, {2, 4, 8, 10}, {13, 3, 6, 7}, {15, 14, 12, 16}};
        solution.print(matrix01);
        System.out.println("------------------");
        solution.rotate(matrix01);
        solution.print(matrix01);
    }

    private void print(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(String.format("%2d ", matrix[i][j]));
            }
            System.out.println();
        }
    }
}