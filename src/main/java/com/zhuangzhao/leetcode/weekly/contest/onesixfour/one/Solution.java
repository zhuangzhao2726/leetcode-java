package com.zhuangzhao.leetcode.weekly.contest.onesixfour.one;

public class Solution {

    public int minTimeToVisitAllPoints(int[][] points) {

        int total = 0;
        for (int i = 0; i < points.length - 1; i++) {
            total += calculateTime(points[i], points[i+1]);
        }
        return total;
    }



    private int calculateTime(int[] point1, int[] point2) {
        return Math.max(Math.abs(point1[0] - point2[0]), Math.abs(point1[1] - point2[1]));
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        int[][] points = {{3,2}, {-2,2}};
        System.out.println(solution.minTimeToVisitAllPoints(points));
    }
}