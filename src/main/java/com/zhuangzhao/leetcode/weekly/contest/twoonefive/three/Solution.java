package com.zhuangzhao.leetcode.weekly.contest.twoonefive.three;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int minOperations(int[] nums, int x) {
        int[] counts = new int[nums.length + 1];
        for (int i  = 0;  i < nums.length; i++) {
            if (i == 0) {
                counts[i] = nums[i];
            } else {
                counts[i] = counts[i - 1] + nums[i];
            }
        }
        int[] revertCounts = new int[nums.length];
        Map<Integer, Integer> countsMap = new HashMap<>();
        for (int i  = nums.length - 1;  i >= 0; i--) {
            if (i == nums.length - 1) {
                revertCounts[i] = nums[i];
            } else {
                revertCounts[i] = revertCounts[i + 1] + nums[i];
            }
            countsMap.put(revertCounts[i], i);
        }
        int min = Integer.MAX_VALUE;
        if (countsMap.containsKey(x)) {
            min = nums.length - countsMap.get(x);
        }
        for (int i = 0; i <= nums.length; i++) {
            if (counts[i] == x) {
                if (i + 1 < min) {
                    min = i + 1;
                }
            }
            if (countsMap.containsKey(x - counts[i]) && countsMap.get(x - counts[i]) > i) {
                if (i + 1 + (nums.length - countsMap.get(x - counts[i])) < min) {
                    min = i + 1 + (nums.length - countsMap.get(x - counts[i]));
                }
            }
        }
        return min == Integer.MAX_VALUE ? -1 :min;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1,1,4,2,3};
        System.out.println(solution.minOperations(nums, 5));
    }
}
