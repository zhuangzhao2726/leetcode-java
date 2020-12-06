package com.zhuangzhao.leetcode.four.seven;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Solution {
    public List<List<Integer>> permuteUnique(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        Set<String> set = new HashSet<>();
        return this.search(list, set, 0);
    }


    private List<List<Integer>> search(List<Integer> list, Set<String> set, int index) {
        List<List<Integer>> result = new ArrayList<>();
        if (index == list.size() -1 && !set.contains(this.list2String(list))) {
            result.add( new ArrayList<>(list));
            set.add(this.list2String(list));
        }
        for (int i  = index; i < list.size();  i++) {
            swap(list, index, i);
            List<List<Integer>> search = this.search(list, set,index + 1);
            if (!search.isEmpty()) {
                result.addAll(search);
            }
            swap(list, index, i);
        }
        return result;
    }

    private void swap(List<Integer> list, int index1, int index2) {
        if (index1 >= 0 && index1 < list.size() && index2 >= 0 && index2 < list.size()) {
            int value = list.get(index1);
            list.set(index1, list.get(index2));
            list.set(index2, value);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,1,1};
        List<List<Integer>> result = solution.permuteUnique(nums);

        for (List<Integer> list : result) {
            System.out.println(solution.list2String(list));
        }
    }

    private String list2String(List<Integer> list) {
        StringBuilder builder = new StringBuilder();
        for (int num :  list) {
            builder.append(num);
            builder.append(", ");
        }
        return builder.toString();
    }
}