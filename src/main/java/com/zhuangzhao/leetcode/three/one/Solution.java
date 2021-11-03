package com.zhuangzhao.leetcode.three.one;

class Solution {
    public void nextPermutation(int[] nums) {
        int length = nums.length;
        int index = 0;
        for (int i = length - 1; i > 0; i--) {
            if (nums[i] > nums[i - 1]) {
                index = i;
                break;
            }
        }

        int value = 0;
        for (int i = 0; i < (length - index) / 2; i++) {
            value = nums[index + i];
            nums[index + i] = nums[length - 1 - i];
            nums[length - 1 - i] = value;
        }
        if (index > 0) {
            for (int i = index; i < length; i++) {
                if (nums[i] > nums[index - 1]) {
                    value = nums[i];
                    nums[i] = nums[index - 1];
                    nums[index - 1] = value;
                    break;
                }
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums = {5, 4, 7, 5, 3, 2};
        solution.nextPermutation(nums);

        for (int num : nums) {
            System.out.print(num + "、");
        }
        System.out.println();
    }
}