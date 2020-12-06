package com.zhuangzhao.leetcode.weekly.contest.twoonefour.one;

class Solution {
    public int getMaximumGenerated(int n) {
        if (n == 0) {
            return 0;
        } else if (n == 1) {
            return 1;
        }

        int[] array = new int[n + 1];
        array[0] = 0;
        array[1] = 1;
        int max = 1;

        for (int i = 2; i < n + 1; i++) {
            if (i % 2 == 0) {
                array[i] = array[i / 2];
            } else {
                array[i] = array[i / 2] + array[i / 2 + 1];
            }
            if (array[i] > max) {
                max = array[i];
            }
        }
        return max;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getMaximumGenerated(7));
    }
}