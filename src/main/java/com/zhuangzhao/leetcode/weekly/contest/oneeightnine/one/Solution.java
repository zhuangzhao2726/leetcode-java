package com.zhuangzhao.leetcode.weekly.contest.oneeightnine.one;

class Solution {
    public int busyStudent(int[] startTime, int[] endTime, int queryTime) {
        int total = 0;
        for (int i =  0; i < startTime.length; i++) {
            if (startTime[i] <= queryTime && endTime[i] >= queryTime) {
                total++;
            }
        }
        return total;
    }
}