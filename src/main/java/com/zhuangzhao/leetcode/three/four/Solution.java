package com.zhuangzhao.leetcode.three.four;

class Solution {

    public int[] searchRange(int[] nums, int target) {
        int left = 0;
        int right = nums.length - 1;
        while (left <= right) {
            if (left < nums.length && nums[left] != target) {
                left++;
            }
            if (right >= 0 && nums[right] != target) {
                right--;
            }
            if (nums[left] == target && nums[right] == target) {
                break;
            }
        }
        int[] result = new int[2];
        result[0] = -1;
        result[1] = -1;
        if (left <= right) {
            result[0] = left;
            result[1] = right;
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {5,7,7,8,8,10};
        int target = 7;
        int[] range = solution.searchRange(nums, target);
        System.out.println(range[0] + ", " + range[1]);
    }
}