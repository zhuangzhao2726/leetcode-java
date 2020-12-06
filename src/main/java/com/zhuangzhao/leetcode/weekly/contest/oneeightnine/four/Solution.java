package com.zhuangzhao.leetcode.weekly.contest.oneeightnine.four;

class Solution {
    public int numPoints(int[][] points, int r) {
        for (int i = 0; i < points.length; i++) {
            for (int j = 0; j < points.length; j++) {
                if (i == j) {
                    search(points, points[i]);
                } else {
                    int[] ceter = {0, 0};
                    search(points, ceter);
                }
            }
        }
        return 0;
    }

    private int search(int[][] points, int[] center) {
        return 0;
    }


    public static void main(String[] args) {
        int i = 10000;
        System.out.println(i * i * 10);
    }
}