package com.zhuangzhao.leetcode.four.four.eight;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> findDisappearedNumbers(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                adjust(nums, i);
            }
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < nums.length; i++) {
            if (nums[i] != i + 1) {
                result.add(i + 1);
            }
        }
        return result;
    }

    private void adjust(int[] nums, int index) {
        while (nums[index] != index + 1 && nums[nums[index] - 1] != nums[index]) {
            int value = nums[nums[index] - 1];
            nums[nums[index] - 1] = nums[index];
            nums[index] = value;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {4,3,2,7,8,2,3,1};
        List<Integer> list = solution.findDisappearedNumbers(nums);
        for (Integer value : list) {
            System.out.println(value);
        }
    }
}