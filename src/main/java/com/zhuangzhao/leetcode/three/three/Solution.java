package com.zhuangzhao.leetcode.three.three;

class Solution {
    public int search(int[] nums, int target) {
        int left = 0;
        int right = nums.length -1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            if (nums[left] == target) {
                return left;
            } else if (nums[mid] == target) {
                return mid;
            } else if (nums[right] == target) {
                return right;
            } else {
                if (nums[left] < nums[mid]) {
                   if (nums[left] < target && nums[mid] > target ) {
                       right = mid -1;
                   } else {
                       left = mid + 1;
                   }
                } else {
                    if (nums[mid] < target && nums[right] > target) {
                        left = mid + 1;
                    } else {
                        right  =  mid - 1;
                    }
                }
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        int[] nums = {4,5,6,7,0,1,2};
        Solution solution = new Solution();
        System.out.println(solution.search(nums,  0));
        System.out.println(solution.search(nums,  1));
        System.out.println(solution.search(nums,  2));
        System.out.println(solution.search(nums,  -1));
    }
}