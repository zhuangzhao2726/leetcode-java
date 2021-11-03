package com.zhuangzhao.leetcode.two.two.one;

class Solution {
    public int maximalSquare(char[][] matrix) {
        int max = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                for (int x = 0; x < matrix.length - i && x < matrix[i].length - j; x++) {
                   int square = this.square(matrix, i, j, x);
                   if (square >= max) {
                       max = square;
                   } else if (square <= 0) {
                       break;
                   }
                }
            }
        }
        return max;
    }


    private int square(char[][] matrix, int i, int j, int x) {
        for (int m = 0; m <= x; m++) {
            if (matrix[i + x][j + m] != '1' || matrix[i + m][j + x] != '1') {
                return -1;
            }
        }
        return (x + 1) * (x + 1);
    }




    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] matrix = {
                {'0','1','1','0','0','1','0','1','0','1'}, 
                {'0','0','1','0','1','0','1','0','1','0'},
                {'1','0','0','0','0','1','0','1','1','0'}, 
                {'0','1','1','1','1','1','1','0','1','0'},
                {'0','0','1','1','1','1','1','1','1','0'},
                {'1','1','0','1','0','1','1','1','1','0'}, 
                {'0','0','0','1','1','0','0','0','1','0'},
                {'1','1','0','1','1','0','0','1','1','1'},
                {'0','1','0','1','1','0','1','0','1','1'}};
        System.out.println(solution.maximalSquare(matrix));
    }

}