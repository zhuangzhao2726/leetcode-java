package com.zhuangzhao.leetcode.weekly.contest.twothreesit.one;

class Solution {
    public int arraySign(int[] nums) {
        int a = 0;
        int b = 0;
        for (int num : nums) {
            if (num < 0) {
                a++;
            } else if (num == 0) {
                b++;
            }
        }
        if (b > 0) {
            return 0;
        } else if ((a & 1) == 1) {
            return -1;
        } else {
            return 1;
        }
    }


    public static void main(String[] args) {

    }
}