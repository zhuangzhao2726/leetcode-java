package com.zhuangzhao.leetcode.weekly.contest.onesixfive.one;

class Solution {
    public String tictactoe(int[][] moves) {

        char[][] map = new char[3][3];
        for(int i = 0; i < moves.length; i++) {
            if(i % 2 ==0) {
                map[moves[i][0]][moves[i][1]] = 'X';
            } else {
                map[moves[i][0]][moves[i][1]] = 'O';
            }
        }

        char win = ' ';
        for (int i = 0; i < 3; i++) {
            if(isNotEmpty(map[i][0]) &&(map[i][0] == map[i][1] && map[i][0]== map[i][2])){
                win = map[i][0];
                break;
            } else if(isNotEmpty(map[0][i]) && map[0][i] == map[1][i] && map[0][i] == map[2][i]){
                win = map[0][i];
                break;

            } else if (isNotEmpty(map[0][0]) && map[0][0] == map[1][1] && map[0][0] == map[2][2]) {
                win = map[0][0];
                break;
            } else if(isNotEmpty(map[0][2]) && map[0][2] == map[1][1] && map[0][2] == map[2][0]){
                win = map[0][2];
                break;
            }
        }
        if (win == 'X') {
            return "A";
        } else if(win == 'O') {
            return "B";
        } else if(moves.length < 9) {
            return "Pending";
        } else {
            return "Draw";
        }
    }

    private boolean isNotEmpty(char c) {
        return c == 'X' || c == 'O';
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] moves = {{0,0},{2,0},{1,1},{2,1},{2,2}};

        System.out.println(solution.tictactoe(moves));

        int[][] moves01 = {{0,0},{1,1},{0,1},{0,2},{1,0},{2,0}};

        System.out.println(solution.tictactoe(moves01));
    }
}