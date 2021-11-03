package com.zhuangzhao.leetcode.weekly.contest.twoonesix.three;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int waysToMakeFair(int[] nums) {
        Map<Integer, Integer> map01 = new HashMap<>();
        int[] sum = new int[2];
        for (int i = 0; i < nums.length; i++) {
            sum[i % 2] = sum[i % 2] + nums[i];
            map01.put(i, sum[i % 2]);
        }

        Map<Integer, Integer> map02 = new HashMap<>();
        int[] sum2 = new int[2];
        for (int i = nums.length - 1; i >= 0; i--) {
            sum2[i % 2] = sum2[i % 2] + nums[i];
            map02.put(i, sum2[i % 2]);
        }

        int count = 0;
        for (int i = 0; i < nums.length; i++) {
            if (map01.getOrDefault(i - 2, 0) + map02.getOrDefault(i + 1, 0) ==
                    map01.getOrDefault(i - 1, 0) + map02.getOrDefault(i + 2, 0)) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {2, 1, 6, 4};
        System.out.println(solution.waysToMakeFair(nums));
    }
}