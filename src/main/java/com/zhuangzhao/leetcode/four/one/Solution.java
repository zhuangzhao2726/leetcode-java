package com.zhuangzhao.leetcode.four.one;

class Solution {

    public int firstMissingPositive(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            while (nums[i] != i + 1 && nums[i] > 0 && nums[i] <= nums.length && nums[i] != nums[nums[i] - 1]) {
                int value = nums[i];
                nums[i] = nums[value - 1];
                nums[value - 1] = value;
            }
        }
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                return i + 1;
            }
        }
        return nums.length == 0? 1 : nums.length + 1;
    }


    public static void main(String[] args) {
        int[] nums = {3,4,-1,1};
        Solution solution = new Solution();
        System.out.println(solution.firstMissingPositive(nums));
    }
}