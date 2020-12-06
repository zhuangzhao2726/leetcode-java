package com.zhuangzhao.leetcode.one.eight;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> fourSum(int[] nums, int target) {

        List<List<Integer>> result = new ArrayList<>();

        nums = sort(nums);

        for (int i = 0; i < nums.length - 3; i ++) {
            if (i > 0 && nums[i] == nums[i - 1]) {
                continue;
            }

            for (int j = nums.length - 1; j > i + 2; j--) {
                if (j < nums.length - 1 && nums[j] == nums[j + 1]) {
                    continue;
                }

                int left = i + 1;
                int right  = j - 1;
                while (left < right) {
                    int total = nums[i] + nums[left] + nums[right] + nums[j];
                    if (total < target) {
                        left++;
                        while (left < right && nums[left] == nums[left - 1])
                            left++;
                    } else if (total == target) {
                        List<Integer> list = new ArrayList<>();
                        list.add(nums[i]);
                        list.add(nums[left]);
                        list.add(nums[right]);
                        list.add(nums[j]);
                        result.add(list);

                        left++;
                        while (left < right && nums[left] == nums[left - 1])
                            left++;
                        right--;
                        while (left < right && nums[right] == nums[right + 1])
                            right--;
                    } else {
                        right--;
                        while (left < right && nums[right] == nums[right + 1])
                            right--;
                    }
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
        int[] nums = {1, 0, -1, 0, -2, 2};
        System.out.println(solution.fourSum(nums, 0));
    }
}