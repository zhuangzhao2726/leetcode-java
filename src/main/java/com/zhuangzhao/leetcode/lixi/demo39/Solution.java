package com.zhuangzhao.leetcode.lixi.demo39;

import sun.lwawt.macosx.CSystemTray;

class Solution {
    public void nextPermutation(int[] nums) {
        if (nums == null || nums.length <= 1) {
            return;
        }
        int index = nums.length - 1;
        while (index > 0) {
            if (nums[index] > nums[index - 1]) {
                break;
            } else {
                index--;
            }
        }

        for (int i = 0; i < nums.length; i++) {

        }

        int keyIndex = 0;
        for (int i = nums.length - 1; i > 0; i--) {
            if (nums[i - 1] < nums[i]) {
                keyIndex = i;
                break;
            }
        }


        int x = index;
        int y = nums.length - 1;
        while (x < y) {
            int temp = nums[x];
            nums[x] = nums[y];
            nums[y] = temp;
            x++;
            y--;
        }

        if (index == 0) {
            return;
        }

        for (int i = index; i < nums.length; i++) {
            if (nums[index - 1] < nums[i]) {
                int temp = nums[i];
                nums[i] = nums[index - 1];
                nums[index - 1] = temp;
                break;
            }
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {1, 2, 5, 4, 3, 2};
        solution.nextPermutation(nums);
        for (int num : nums) {
            System.out.print(num + "; ");
        }


    }
}