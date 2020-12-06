package com.zhuangzhao.leetcode.five.five;

import java.util.HashSet;
import java.util.Set;

class Solution {
    public boolean canJump(int[] nums) {
        int max = 0;
        for (int i = 0; i < nums.length; i++) {
            if (max >= i){
                int value = i + nums[i];
                if (value > max) {
                    max = value;
                }
            } else {
                break;
            }
        }
        return max >= nums.length - 1;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {3,2,1,0,4};
        System.out.println(solution.canJump(nums));
    }
}