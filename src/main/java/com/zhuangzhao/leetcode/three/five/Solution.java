package com.zhuangzhao.leetcode.three.five;

class Solution {
    public int searchInsert(int[] nums, int target) {
        for (int i = 0; i <= nums.length; i++) {
            if (i < nums.length && nums[i] >= target) {
                return i;
            } else if (i + 1 < nums.length && nums[i + 1] > target) {
                return i + 1;
            } else if (i == nums.length) {
                return i;
            }
        }
        return -1;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 3, 5, 6};
        System.out.println(solution.searchInsert(nums, 1));
        System.out.println(solution.searchInsert(nums, 2));
        System.out.println(solution.searchInsert(nums, 3));
        System.out.println(solution.searchInsert(nums, 4));
        System.out.println(solution.searchInsert(nums, 5));
        System.out.println(solution.searchInsert(nums, 6));
        System.out.println(solution.searchInsert(nums, 7));
    }
}