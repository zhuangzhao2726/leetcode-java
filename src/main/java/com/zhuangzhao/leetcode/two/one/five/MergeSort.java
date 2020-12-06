package com.zhuangzhao.leetcode.two.one.five;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2020-12-01 11:42
 */
public class MergeSort {



    private void sort(int[] nums) {
        int[] var = new int[nums.length];
        this.sort(nums, 0, nums.length - 1, var);
    }

    private void sort(int[] nums, int left, int right, int[] var) {
        if (left < right) {
            int mid = left + (right - left) / 2;
            sort(nums, left, mid, var);
            sort(nums, mid + 1, right, var);
            this.merge(nums, left, mid, right, var);
        }
    }

    private void merge(int[] nums, int left, int mid, int right, int[] var) {
        int i = left;
        int j = mid + 1;
        int index = left;
        while (i <= mid || j <= right) {
            if (i > mid) {
                var[index++] = nums[j++];
            } else if (j > right) {
                var[index++] = nums[i++];
            } else if (nums[i] <= nums[j]) {
                var[index++] = nums[i++];
            } else {
                var[index++] = nums[j++];
            }
        }
        for (int x = left; x <= right; x++) {
            nums[x] = var[x];
        }
    }

    public static void main(String[] args) {
        MergeSort mergeSort = new MergeSort();
        int[] nums = {9,8,7,6,5,4,3,2,1};
        mergeSort.print(nums);
        mergeSort.sort(nums);
        mergeSort.print(nums);
    }

    private void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num + "   ");
        }
        System.out.println();
    }
}
