package com.zhuangzhao.leetcode.weekly.contest.onesixnine.one;

class Solution {
    public int[] sumZero(int n) {

        int[] result = new int[n];
        if (n % 2 == 0) {
            setValue(result, n);
        } else {
            setValue(result, n-3);
            setValue(result, n-3, n-1);
        }
        return result;
    }

    private void setValue(int[] result, int start, int end) {




    }

    private void setValue(int[] result, int n) {
        for (int i =0; i < n; i++) {
            result[i] = (int) Math.pow(-1, i) * (i / 2 + 1);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sumZero(5));
    }
}