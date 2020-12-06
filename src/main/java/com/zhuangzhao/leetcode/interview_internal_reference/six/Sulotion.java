package com.zhuangzhao.leetcode.interview_internal_reference.six;

import com.zhuangzhao.leetcode.interview_internal_reference.five.Solution;

import java.util.HashMap;
import java.util.Map;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2020-10-07 19:37
 */
public class Sulotion {
    public int[] findTwoNum(int[] nums, int target) {
        int[] result = {-1, -1};
        if (nums == null || nums.length < 2) {
            return result;
        }
        Map<Integer, Integer> map = new HashMap<>();
        for (int i = 0; i < nums.length; i++) {
            if (map.containsKey(target - nums[i])) {
                result[0] = map.get(target - nums[i]);
                result[1] = i;
                break;
            } else {
                map.put(nums[i], i);
            }
        }
        return result;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();


        solution.hashCode();
    }
}
