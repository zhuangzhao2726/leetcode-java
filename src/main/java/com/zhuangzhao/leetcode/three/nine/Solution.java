package com.zhuangzhao.leetcode.three.nine;

import java.util.ArrayList;
import java.util.List;

class Solution {







    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        this.sort(candidates);
        return seach(candidates, target, new ArrayList<>());
    }



    public List<List<Integer>> seach(int[] candidates, int target, List<Integer> nums) {
        if (target == 0) {
            List<List<Integer>> lists = new ArrayList<>();
            lists.add(new ArrayList(nums));
            return lists;
        }
        List<List<Integer>> result = new ArrayList<>();
        int min = nums.isEmpty() ? candidates[0] : nums.get(nums.size() - 1);
        for (int num : candidates) {
            if (num >= min && num <= target) {
                nums.add(num);
                List<List<Integer>> seach = seach(candidates, target - num, nums);
                if (!seach.isEmpty()) {
                    result.addAll(seach);
                }
                nums.remove(nums.size() -1);
            }
        }
        return result;
    }


    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min  = nums[i];
            int index = i;
            for (int j = i; j < nums.length; j++) {
                if (nums[j] < min) {
                    min = nums[j];
                    index = j;
                }
            }
            if (i < index) {
                int value = nums[i];
                nums[i] = nums[index];
                nums[index] = value;
            }
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums  = {2, 3, 6, 7};
        List<List<Integer>> lists = solution.combinationSum(nums, 8);
        for (List<Integer> list : lists) {
            StringBuilder builder = new StringBuilder();
            for (Integer num : list) {
                builder.append(num);
                builder.append(", ");
            }
            System.out.println(builder.toString());
        }
    }
}