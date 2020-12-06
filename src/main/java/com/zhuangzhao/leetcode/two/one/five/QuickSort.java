package com.zhuangzhao.leetcode.two.one.five;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2020-12-01 11:24
 */
public class QuickSort {


    private void sort(int[] nums) {
        this.quickSort(nums, 0, nums.length - 1);

    }


    public void quickSort(int[] nums, int left, int right) {
        if (left < right) {
            int i = left;
            int j = right;
            while (i < j) {
                while (i <= right && nums[i] <= nums[left]) i++;
                while (j >= left && nums[j] >= nums[left]) j--;
                if (i < j) {
                    int t = nums[i];
                    nums[i] = nums[j];
                    nums[j] = t;
                }
            }
            if (i <= right) {
                int t = nums[left];
                nums[left] = nums[i];
                nums[i] = t;
            }
            quickSort(nums, left, i - 1);
            quickSort(nums, i + 1, right);
        }
    }


    public static void main(String[] args) {
        QuickSort quickSort = new QuickSort();
        int[] nums = {9,1,7,6,5,4,3,2,8};
        quickSort.print(nums);
        quickSort.sort(nums);
        quickSort.print(nums);
    }

    private void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num + "   ");
        }
        System.out.println();
    }
}
