package com.zhuangzhao.leetcode.four.five;

class Solution {
    public int jump(int[] nums) {
        int stepMax = 0;
        int minStep = 0;
        int nextStepMax = nums[0];
        for (int i = 1; i < nums.length; i++) {
            if (i > stepMax) {
                stepMax = nextStepMax;
                minStep++;
            }
            if (i + nums[i] >= nextStepMax) {
                nextStepMax = i + nums[i];
            }
        }
        return minStep;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 3, 1, 1, 4};
        System.out.println(solution.jump(nums));
    }
}