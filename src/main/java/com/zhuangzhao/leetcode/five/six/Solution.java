package com.zhuangzhao.leetcode.five.six;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int[][] merge(int[][] intervals) {
        List<List<Integer>> intervalList = new ArrayList<>();
        for (int[] interval : intervals) {
            List<Integer> list = new ArrayList<>();
            list.add(interval[0]);
            list.add(interval[1]);
            intervalList.add(list);
        }
        List<List<Integer>> lists = this.merge(intervalList);
        int[][] result = new int[lists.size()][];
        int index = 0;
        for (List<Integer> list : lists) {
            result[index] = new int[2];
            result[index][0] = list.get(0);
            result[index][1] = list.get(1);
            index++;
        }
        return result;
    }

    private List<List<Integer>> merge(List<List<Integer>> intervals) {
        List<List<Integer>> result = new ArrayList<>();
        for (List<Integer> interval : intervals) {
            this.merge(result, interval);
        }
        if (result.size() < intervals.size()) {
            return this.merge(result);
        } else {
            return result;
        }
    }

    private void merge(List<List<Integer>> result, List<Integer> interval) {
        boolean match = false;
        for (int i = 0; i < result.size(); i++) {
            List<Integer> list = result.get(i);
            if ((interval.get(1) - list.get(0)) * (interval.get(0) - list.get(1)) <= 0) {
                match = true;
                if (interval.get(0) < list.get(0)) {
                    list.set(0, interval.get(0));
                }
                if (interval.get(1) > list.get(1)) {
                    list.set(1, interval.get(1));
                }
            }
        }
        if (!match) {
            result.add(interval);
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] intervals = {{1, 3}, {2, 6}, {8, 10}, {15, 18}};
        int[][] result = solution.merge(intervals);
        solution.print(result);
    }

    private void print(int[][] result) {
        for (int[] nums : result) {
            System.out.println(nums[0] + "    " + nums[1]);
        }
    }
}