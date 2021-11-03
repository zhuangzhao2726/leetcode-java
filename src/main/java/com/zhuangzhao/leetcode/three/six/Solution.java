package com.zhuangzhao.leetcode.three.six;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public boolean isValidSudoku(char[][] board) {
        int row = board.length;
        int col = board[0].length;

        for (char[] chars : board) {
            boolean flag = checkRow(chars);
            if (!flag) {
                return false;
            }
        }
        for (int i = 0; i < col; i++) {
            char[] charCol = new char[row];
            for (int j = 0; j < row; j++) {
                charCol[j] = board[j][i];
            }
            boolean flag = checkRow(charCol);
            if (!flag) {
                return false;
            }
        }
        for (int i = 0; i < row; i += 3) {
            for (int j = 0; j < col; j += 3) {
                char[] charBlock = new char[3 * 3];
                for (int x = 0; x < 3; x++) {
                    for (int y = 0; y < 3; y++) {
                        charBlock[x * 3 + y] = board[i + x][j + y];
                    }
                }
                boolean flag = checkRow(charBlock);
                if (!flag) {
                    return false;
                }
            }
        }
        return true;
    }

    private boolean checkRow(char[] chars) {
        Map<Character, Integer> map = new HashMap<Character, Integer>();
        for (char aChar : chars) {
            if ('.' == aChar) {
                continue;
            } else if (map.containsKey(aChar)) {
                return false;
            } else {
                map.put(aChar, 1);
            }
        }
        return true;
    }
}