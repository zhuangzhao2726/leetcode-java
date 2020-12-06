package com.zhuangzhao.leetcode.two.one.five;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2020-12-01 10:35
 */
public class HeapSort {

    private void headSort(int[] nums) {
        for (int i = (nums.length - 1) / 2; i >= 0; i--) {
            this.adjust(nums, i, nums.length);
        }
        this.print(nums);
        for (int i = nums.length - 1; i > 0; i--) {
            int value = nums[0];
            nums[0] = nums[i];
            nums[i] = value;
            this.adjust(nums, 0, i);
        }
    }

    private void adjust(int[] nums, int index, int length) {
        // 最大堆
//        while (index * 2 + 1 < length) {
//            int max = nums[index];
//            int i = index;
//            if (nums[index * 2 + 1] >  max) {
//                max = nums[index * 2 + 1];
//                i = index * 2 + 1;
//            }
//            if (index * 2 + 2 < length && nums[index * 2 + 2] > max) {
//                i = index * 2 + 2;
//            }
//            if (index != i) {
//                int value = nums[index];
//                nums[index] = nums[i];
//                nums[i] = value;
//                index = i;
//            } else {
//                break;
//            }
//        }

        // 最小堆
        while (index * 2 + 1 < length) {
            int min  = nums[index];
            int i = index;
            if (nums[index * 2 + 1] < nums[index]) {
                min = nums[index * 2 + 1];
                i = index * 2 + 1;
            }
            if (index * 2 + 2 < length && nums[index * 2 + 2] < min) {
                min = nums[index * 2 + 2];
                i = index * 2 + 2;
            }
            if (i != index) {
                int value = nums[index];
                nums[index] = nums[i];
                nums[i] = value;
                index = i;
            } else {
                break;
            }
        }
    }


    public static void main(String[] args) {
        HeapSort heapSort = new HeapSort();
        int[] nums = {1,10,3,4,5,6,7,8,9};
        heapSort.print(nums);
        heapSort.headSort(nums);
        heapSort.print(nums);
    }


    private void print(int[] nums) {
        for (int num : nums) {
            System.out.print(num + "    ");
        }
        System.out.println();
    }
}
