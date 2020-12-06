package com.zhuangzhao.leetcode.four.two;

class Solution1 {
    public int trap(int[] height) {
        int total = 0;
        int left = 0;
        int right = height.length - 1;
        while (left < right) {
            for (int i = left + 1, count = 0; i <= right; i++) {
                if (height[i] >= height[left]) {
                    total += count;
                    left = i;
                    count = 0;
                } else {
                    count += height[left] - height[i];
                }
            }

            for (int i = right - 1, count = 0; i >= left; i--) {
                if (height[i] >= height[right]) {
                    total += count;
                    right = i;
                    count = 0;
                } else {
                    count += height[right] - height[i];
                }
            }
        }
        return total;
    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(solution.trap(height));
    }
}