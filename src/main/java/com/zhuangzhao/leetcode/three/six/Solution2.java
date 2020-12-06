package com.zhuangzhao.leetcode.three.six;

import java.util.HashMap;
import java.util.Map;

class Solution2 {


    public boolean isValidSudoku(char[][] board) {

        int row = board.length;
        int col = board.length;


        Map<Character, Integer>[] rowMap = new Map[row];
        Map<Character, Integer>[] colMap = new Map[col];
        Map<Character, Integer>[] boxMap = new Map[(row / 3) * 3 + (col / 3) * 3];

        for (int i = 0; i < row; i++) {
            rowMap[i] = new HashMap<>();
            colMap[i] = new HashMap<>();
            boxMap[i] = new HashMap<>();
        }

        for (int  i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if('.' != board[i][j]) {
                    int boxIndex = (i / 3) * 3 + (j / 3) * 3;

                    int rowCount = rowMap[i].getOrDefault(board[i][j], 0);
                    int colCount = colMap[j].getOrDefault(board[i][j], 0);
                    int boxCount = boxMap[boxIndex].getOrDefault(board[i][j], 0);

                    if(rowCount + colCount + boxCount > 0) {
                        return false;
                    } else {
                        rowMap[i].put(board[i][j], rowCount + 1);
                        colMap[j].put(board[i][j], colCount + 1);
                        boxMap[boxIndex].put(board[i][j], boxCount + 1);
                    }
                }

            }
        }
        return true;
    }

}