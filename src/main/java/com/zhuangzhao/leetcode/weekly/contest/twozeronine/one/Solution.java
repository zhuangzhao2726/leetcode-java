package com.zhuangzhao.leetcode.weekly.contest.twozeronine.one;

class Solution {
    public int specialArray(int[] nums) {
        int count = 0;
        for (int i = 100; i>= 0; i--) {
            for (int j = 0; j < nums.length; j++) {
                if (i == 100 && nums[j] >= i) {
                    count ++;
                } else if (nums[j] == i) {
                    count++;
                }
            }
            if (count == i)  {
                return i;
            }
        }
        return -1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {0, 4, 3, 0, 4};
        System.out.println(solution.specialArray(nums));

        int[] nums01 = {3, 6, 7, 7, 0};
        System.out.println(solution.specialArray(nums01));
    }
}