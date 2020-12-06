package com.zhuangzhao.leetcode.one.one;

class Solution {
    public int maxArea(int[] height) {
        int left = 0;
        int right = height.length -1;
        int max = 0;
        while (left < right) {
            int minHeight = height[left] <= height[right] ? height[left] : height[right];
            if ((right - left) * minHeight > max) {
                max = (right - left) * minHeight;
            }
            if (height[left] <= height[right]) {
                left++;
            } else {
                right--;
            }
        }
        return max;
    }
}