package com.zhuangzhao.leetcode.weekly.contest.twofourfour.two;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

class Solution {
    public int reductionOperations(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>();
        Set<Integer> set = new HashSet<>();
        for (int i : nums) {
            map.put(i, map.getOrDefault(i, 0) + 1);
            set.add(i);
        }
        List<Integer> list = new ArrayList<>(set);
        list.sort(Comparator.comparingInt(Integer::intValue));
        int count = 0;
        if (list.size() > 1) {
            int num = 0;
            for (int i = list.size() - 1; i > 0; i--) {
                num += map.get(list.get(i));
                count += num;
            }
        }
        return count;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.reductionOperations(new int[] {1,2,34,5}));
    }
}