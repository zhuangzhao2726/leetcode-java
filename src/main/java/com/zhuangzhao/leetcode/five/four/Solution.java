package com.zhuangzhao.leetcode.five.four;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> spiralOrder(int[][] matrix) {
        if (matrix.length == 0 || matrix[0].length == 0) {
            return new ArrayList<>();
        }
        int row = matrix.length;
        int col = matrix[0].length;
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < (row + 1) / 2 && i < (col + 1) / 2; i++) {
            for (int j = i; j < col - i; j++)
                list.add(matrix[i][j]);
            for (int j = i + 1; j < row - i; j++)
                list.add(matrix[j][col - 1 - i]);
            if (row / 2 > i )
                for (int j = col - 2 - i;  j >= i; j--)
                    list.add(matrix[row - 1 - i][j]);
            if (col / 2 > i)
                for (int j = row - 2 - i; j > i; j--)
                    list.add(matrix[j][i]);
        }
        return list;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] matrix = {{2, 5, 8}, {4, 0, -1}};
        List<Integer> list = solution.spiralOrder(matrix);
        solution.print(list);
    }

    private void print(List<Integer> list) {
        for (int num : list) {
            System.out.print(num + ", ");
        }
    }
}