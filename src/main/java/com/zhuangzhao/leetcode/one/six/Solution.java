package com.zhuangzhao.leetcode.one.six;


class Solution {
    public int threeSumClosest(int[] nums, int target) {

        nums = sort(nums);
        int result = 0;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {
            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (min > Math.abs(sum - target)) {
                    min = Math.abs(sum - target);
                    result = sum;
                }
                if (sum <= 0) {
                    left++;
                } else {
                    right--;
                }
            }
        }
        return result;
    }


    private int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            int value = nums[i];
            nums[i] = nums[min];
            nums[min] = value;
        }
        return nums;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1, 2, 1, -4};
        System.out.println(solution.threeSumClosest(nums, 1));
    }
}