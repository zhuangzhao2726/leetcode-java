package com.zhuangzhao.leetcode.four.two;

class Solution {
    public int trap(int[] height) {
        int total = 0;
        boolean reach = false;
        int index = 1;
        do {
            reach = false;
            int count = -1;
            for (int i = 0; i < height.length; i++) {
                if (height[i] >= index) {
                    if (count < 0) {
                        count = 0;
                    } else if (count > 0) {
                        total += count;
                        count = 0;
                    }
                    reach = true;
                } else if (count >= 0) {
                    count++;
                }
            }
            index++;
        } while (reach);
        return total;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] height = {4, 2, 0, 3, 2, 5};
        System.out.println(solution.trap(height));
    }
}