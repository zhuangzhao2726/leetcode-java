package com.zhuangzhao.leetcode.one.one.eight;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<List<Integer>> generate(int numRows) {
        List<List<Integer>> result = new ArrayList<>();
        for (int i = 1; i <= numRows; i++) {
            List<Integer> list = new ArrayList<>();
            if (i == 1) {
                list.add(1);
                result.add(list);
            } else {
                List<Integer> listRow = result.get(i - 2);
                for (int j = 0; j < i; j++) {
                    if (j == 0 || j == i - 1) {
                        list.add(1);
                    } else {
                        list.add(listRow.get(j - 1) + listRow.get(j));
                    }
                }
                result.add(list);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        List<List<Integer>> result = solution.generate(5);
        System.out.println(result.size());
    }
}