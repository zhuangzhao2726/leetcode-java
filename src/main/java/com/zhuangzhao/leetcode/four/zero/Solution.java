package com.zhuangzhao.leetcode.four.zero;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> combinationSum2(int[] candidates, int target) {
        this.sort(candidates);
        List<List<Integer>> lists = this.search(candidates, target, 0, new ArrayList<>());
        return this.filter(lists);
    }

    private List<List<Integer>> filter(List<List<Integer>> lists) {
        List<List<Integer>> result = new ArrayList<>();
        new ArrayList<>();
        Set<String> set = new HashSet<>();
        for (List<Integer> list : lists) {
            String key = this.list2String(list);
            if (!set.contains(key)) {
                set.add(key);
                result.add(list);
            }
        }
        return result;
    }

    private String list2String(List<Integer> list) {
        if (list == null || list.isEmpty()) {
            return null;
        } else {
            StringBuilder builder = new StringBuilder();
            for (int num : list) {
                builder.append(num).append(",");
            }
            return builder.toString();
        }
    }


    public List<List<Integer>> search(int[] candidates, int target, int index, List<Integer> nums) {
        List<List<Integer>> result = new ArrayList<>();
        if (target == 0) {
            result.add(new ArrayList<>(nums));
        } else if (index < candidates.length && candidates[index] <= target) {
            nums.add(candidates[index]);
            List<List<Integer>> result01 = this.search(candidates, target - candidates[index], index + 1, nums);
            result.addAll(result01);
            nums.remove(nums.size() - 1);
            List<List<Integer>> result02 = this.search(candidates, target, index + 1, nums);
            result.addAll(result02);
        }
        return result;
    }

    public void sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = nums[i];
            int index = i;
            for (int j = i + 1; j < nums.length; j++) {
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
        return;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {10, 1, 2, 7, 6, 1, 5};
        List<List<Integer>> lists = solution.combinationSum2(nums, 8);
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