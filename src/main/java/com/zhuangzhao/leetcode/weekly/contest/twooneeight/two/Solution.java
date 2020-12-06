package com.zhuangzhao.leetcode.weekly.contest.twooneeight.two;

import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

class Solution {
    public int maxOperations(int[] nums, int k) {
        Set<Integer> set = new HashSet<>();
        Map<Integer, Integer> map = new HashMap<>();
        for (int num : nums) {
            set.add(num);
            map.put(num, map.getOrDefault(num, 0) + 1);
        }
        int count = 0;
        for (int num : set) {
            int max = 0;
            if (num == k - num) {
                max = map.get(num) / 2;
            } else {
                max = map.getOrDefault(num, 0) < map.getOrDefault(k - num, 0) ?
                        map.getOrDefault(num, 0) : map.getOrDefault(k - num, 0);
            }
            if (max > 0) {
                map.put(num, map.get(num) - max);
                map.put(k - num, map.get(k - num) - max);
                count += max;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,1,3,4,3};
        System.out.println(solution.maxOperations(nums, 6));
    }
}