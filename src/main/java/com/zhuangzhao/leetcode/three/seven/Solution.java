package com.zhuangzhao.leetcode.three.seven;

import javafx.util.Pair;

import java.util.ArrayList;
import java.util.List;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();
        char[][] board = {
                {'5', '3', '.', '.', '7', '.', '.', '.', '.'},
                {'6', '.', '.', '1', '9', '5', '.', '.', '.'},
                {'.', '9', '8', '.', '.', '.', '.', '6', '.'},
                {'8', '.', '.', '.', '6', '.', '.', '.', '3'},
                {'4', '.', '.', '8', '.', '3', '.', '.', '1'},
                {'7', '.', '.', '.', '2', '.', '.', '.', '6'},
                {'.', '6', '.', '.', '.', '.', '2', '8', '4'},
                {'.', '.', '.', '4', '1', '9', '.', '.', '5'},
                {'.', '.', '.', '.', '8', '.', '.', '7', '9'}
        };
        solution.solveSudoku(board);


        System.out.println("----------------------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }


    }


    public void solveSudoku(char[][] board) {
        while (countPoint(board) > 0) {
            fillSudokuRaw(board);
            fillSudokuCol(board);
            fillSudokuBox(board);
        }
    }


    private int countPoint(char[][] board) {
        System.out.println("----------------------------");
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                System.out.print(board[i][j] + "  ");
            }
            System.out.println();
        }


        int count = 0;
        for (int i = 0; i < board.length; i++) {
            for (int j = 0; j < board[i].length; j++) {
                if (board[i][j] == '.') {
                    count++;
                }
            }
        }
        return count;
    }



    public boolean fillSudokuCol(char[][] board) {
        for (int i = 0; i < board[0].length; i++) {
            char[] col = new char[board.length];
            for (int j = 0; j < board.length; j++) {
                col[j] = board[j][i];
            }
            Pair<Integer, Character> pair = findLastChar(col);
            if (pair.getKey() > 0) {
                board[pair.getKey()][i] = pair.getValue();
            }
        }
        return true;
    }


    public boolean fillSudokuRaw(char[][] board) {
        for (int i = 0; i < board.length; i++) {
            Pair<Integer, Character> pair = this.findLastChar(board[i]);
            if (pair.getKey() >= 0) {
                board[i][pair.getKey()] = pair.getValue();
            }
        }
        return true;
    }

    public boolean fillSudokuBox(char[][] board){
        for (int i = 0; i < 9; i+=3) {
            for (int j = 0; j < 9; j+=3) {
                char[] array = new char[9];
                for (int row = 0; row < 3; row ++) {
                    for (int col = 0; col < 3; col++) {
                        array[row * 3 + col] = board[i + row][j + col];
                    }
                }
                Pair<Integer, Character> pair = this.findLastChar(array);
                if (pair.getKey() >= 0) {
                    board[i + pair.getKey() / 3][j + pair.getKey() % 3] = pair.getValue();
                }
            }
        }
        return true;
    }


    private Pair<Integer, Character> findLastChar(char[] array) {
        int index = -1;
        int count = 0;
        List<Character> allNumsList = this.getALLNumsList();
        for (int i = 0; i < array.length; i++) {
            allNumsList.remove((Character) array[i]);
            if (array[i] =='.') {
                count++;
                if (index < 0) {
                    index = i;
                }
            }
        }
        if (count == 1) {
            return new Pair<>(index, allNumsList.get(0));
        } else {
            return new Pair<>(-1, '.');
        }
    }

    private List<Character> getALLNumsList() {
        List<Character> list = new ArrayList<>();
        for (int i = 1; i <= 9; i++) {
            list.add((char) ('0' + i));
        }
        return list;
    }
}