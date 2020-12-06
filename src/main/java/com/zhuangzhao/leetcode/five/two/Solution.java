package com.zhuangzhao.leetcode.five.two;

class Solution {
    public int totalNQueens(int n) {
        return this.search(new int[n], n, 0);
    }

    private int search(int[] nums, int n, int index) {
        int count = 0;
        if (index == n) {
            count++;
        } else {
            for (int i = 0; i < n; i++) {
                if(canPlace(nums, index, i)) {
                    nums[index] = i;
                    count += this.search(nums, n, index + 1);
                }
            }
        }
        return count;
    }

    private boolean canPlace(int[] nums, int index, int value) {
        boolean canPlace = true;
        for (int i = 0; canPlace && i < index; i++) {
            if (nums[i] == value) {
                canPlace = false;
            } else if (nums[i] - value == i - index) {
                canPlace = false;
            } else if (nums[i] - value == -(i - index)) {
                canPlace = false;
            }
        }
        return canPlace;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.totalNQueens(8));
    }
}