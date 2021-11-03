package com.zhuangzhao.leetcode.two.six;

class Solution {
    public int removeDuplicates(int[] nums) {
        int value = Integer.MIN_VALUE;
        int count = 0;
        for (int num : nums) {
            if (num > value) {
                nums[count] = num;
                value = num;
                count++;
            }
        }
        return count;
    }
}