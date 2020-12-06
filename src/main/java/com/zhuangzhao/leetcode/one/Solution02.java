package com.zhuangzhao.leetcode.one;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2019-07-19 22:29
 */
public class Solution02 {

    public int[] twoSum(int[] nums, int target) {

        Map<Integer, Integer> numMap = new HashMap<Integer, Integer>(nums.length);

        int[] result = new int[2];

        for (int i = 0; i < nums.length; i++) {
            if (numMap.containsKey(target - nums[i])) {
                result[0] = numMap.get(target - nums[i]);
                result[1] = i;
                break;
            } else {
                numMap.put(nums[i], i);
            }
        }
        return result;
    }
}
