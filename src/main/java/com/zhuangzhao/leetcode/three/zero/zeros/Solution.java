package com.zhuangzhao.leetcode.three.zero.zeros;

class Solution {
    public int lengthOfLIS(int[] nums) {
        if (nums.length == 0) {
            return 0;
        }
        int[] count = new int[nums.length];
        count[0] = 1;
        int result = 1;
        for (int i = 1; i < nums.length; i++) {
            int max = 0;
            for (int j = 0; j < i; j++) {
                if (nums[j] < nums[i] && count[j] > max) {
                    max = count[j];
                }
            }
            count[i] = max + 1;
            if (count[i] > result) {
                result = count[i];
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {7,7,7,7,7,8,1};
        System.out.println(solution.lengthOfLIS(nums));
    }
}