package com.zhuangzhao.leetcode.two.seven;

class Solution {
    public int removeElement(int[] nums, int val) {
        int count = 0;
        for (int num : nums) {
            if (num != val) {
                nums[count] = num;
                count++;
            }
        }
        return count;
    }
}