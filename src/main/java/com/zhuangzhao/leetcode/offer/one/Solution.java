package com.zhuangzhao.leetcode.offer.one;

import java.util.HashMap;
import java.util.Map;

class Solution {
    public int findRepeatNumber(int[] nums) {
        Map<Integer, Integer> map = new HashMap<>(nums.length);
        for (int num : nums) {
            if (map.containsKey(num)) {
                return num;
            } else {
                map.put(num, 1);
            }
        }
        return 0;
    }
}