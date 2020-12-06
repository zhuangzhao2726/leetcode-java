package com.zhuangzhao.leetcode.daily.one;

class Solution {
    public void nextPermutation(int[] nums) {
        int index = 0;
        for (int i = nums.length -1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                index = i;
                break;
            }
        }
        for (int i = 0; i < (nums.length - index) / 2; i++) {
            int value = nums[index + i];
            nums[index + i] = nums[nums.length - 1 - i];
            nums[nums.length - 1 - i] = value;
        }
        if (index > 0) {
            for (int i = index; i < nums.length; i++) {
                if (nums[index - 1] < nums[i]) {
                    int value = nums[index - 1];
                    nums[index - 1] = nums[i];
                    nums[i] = value;
                    break;
                }
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3};
        solution.nextPermutation(nums);

    }
}