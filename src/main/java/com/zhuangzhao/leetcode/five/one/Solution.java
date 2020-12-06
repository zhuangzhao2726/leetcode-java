package com.zhuangzhao.leetcode.five.one;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<String>> solveNQueens(int n) {
        List<List<Integer>> lists = this.sreach(new int[n], n, 0);
        return this.generateRessult(lists, n);
    }



    private List<List<Integer>> sreach(int[] nums, int n, int index) {
        List<List<Integer>> result = new ArrayList<>();
        if (index == n) {
            result.add(generateRessult(nums));
        } else {
            for (int i = 0; i < n; i++) {
                if (this.canPlace(nums, index, i)) {
                    nums[index] = i;
                    result.addAll(this.sreach(nums, n, index + 1));
                }
            }
        }
        return result;
    }

    private boolean canPlace(int[] nums, int index, int num) {
        boolean canPlace = true;
        for (int i = 0; canPlace && i < index; i++) {
            if (nums[i] == num) {
                canPlace = false;
            } else if (nums[i] - num == i - index) {
                canPlace = false;
            } else if (nums[i] - num == - (i - index)) {
                canPlace = false;
            }
        }
        return canPlace;
    }

    private List<Integer> generateRessult(int[] nums) {
        List<Integer> list = new ArrayList<>(nums.length);
        for (int num : nums) {
            list.add(num);
        }
        return list;
    }


    private List<List<String>> generateRessult(List<List<Integer>> lists, int n) {
        List<List<String>> result = new ArrayList<>();
        for (List<Integer> list : lists) {
            result.add(this.int2String(list, n));
        }
        return result;
    }

    private List<String> int2String(List<Integer> list, int n) {
        List<String> result = new ArrayList<>();
        for (int num : list) {
            StringBuffer buffer = new StringBuffer();
            for (int i = 0; i < n; i++) {
                if (i == num) {
                    buffer.append("Q");
                } else {
                    buffer.append(".");
                }
            }
            result.add(buffer.toString());
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<String>> lists = solution.solveNQueens(4);
        for (List<String> list : lists) {
            solution.print(list);
        }
    }

    private void print(List<String> list) {
        for (String str : list) {
            System.out.println(str);
        }
        System.out.println("-------------------");
    }
}