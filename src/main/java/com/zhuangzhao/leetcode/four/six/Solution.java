package com.zhuangzhao.leetcode.four.six;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> permute(int[] nums) {
        List<Integer> list = new ArrayList<>();
        for (int num : nums) {
            list.add(num);
        }
        return this.search(list, 0);
    }


    public void sort(int[] nums) {

    }


    private List<List<Integer>> search(List<Integer> list, int index) {
        List<List<Integer>> result = new ArrayList<>();
        if (index == list.size() -1) {
            result.add( new ArrayList<>(list));
        }
        for (int i  = index; i < list.size();  i++) {
            swap(list, index, i);
            List<List<Integer>> search = this.search(list, index + 1);
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
        int[] nums = {1,2,3,4};
        List<List<Integer>> result = solution.permute(nums);

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