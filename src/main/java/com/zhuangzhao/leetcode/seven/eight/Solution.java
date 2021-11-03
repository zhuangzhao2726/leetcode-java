package com.zhuangzhao.leetcode.seven.eight;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        return search(new ArrayList<>(), nums, 0);
    }

    public List<List<Integer>> search(List<Integer> indexList, int[] nums, int index) {
        List<List<Integer>> result = new ArrayList<>();
        if (index == nums.length) {
            result.add(generateList(nums, indexList));
        }
        if (index < nums.length) {
            indexList.add(index);
            result.addAll(search(indexList, nums, index + 1));
            indexList.remove((Integer) index);
            result.addAll(search(indexList, nums, index + 1));
        }
        return result;
    }

    private List<Integer> generateList(int[] nums, List<Integer> indexList) {
        List<Integer> list = new ArrayList<>();
        for (Integer index : indexList) {
            list.add(nums[index]);
        }
        return list;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,2,3,4};
        List<List<Integer>> result = solution.subsets(nums);
        System.out.println(result);
    }
}