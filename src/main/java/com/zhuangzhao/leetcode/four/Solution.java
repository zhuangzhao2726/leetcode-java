package com.zhuangzhao.leetcode.four;

class Solution {
    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int length1 = nums1.length;
        int length2 = nums2.length;
        int length = length1 + length2;

        int index1 = 0;
        int index2 = 0;

        int[] num = new int[length1 + length2];
        int index = 0;
        while (index1 < length1 || index2 < length2) {
            if (index1 == length1) {
                num[index++] = nums2[index2++];
            } else if (index2 == length2) {
                num[index++] = nums1[index1++];
            } else if (nums1[index1] <= nums2[index2]) {
                num[index++] = nums1[index1++];
            } else {
                num[index++] = nums2[index2++];
            }
        }
        return ((double) (num[(length - 1) / 2] + num[length / 2])) / 2;
    }
}