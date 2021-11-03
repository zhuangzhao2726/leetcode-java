package com.zhuangzhao.leetcode.weekly.contest.fivefourzero.one;

class Solution {
    public boolean kLengthApart(int[] nums, int k) {

        for (int i = 0, m = k; i < nums.length; i++) {
            if (nums[i] == 1) {
                if (m >= k) {
                    m = 0;
                } else {
                    return false;
                }
            } else {
                m++;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        int[] nums = {1, 0, 0, 1, 0, 1};
        int k = 1;
        Solution solution = new Solution();
        System.out.println(solution.kLengthApart(nums, k));
    }
}