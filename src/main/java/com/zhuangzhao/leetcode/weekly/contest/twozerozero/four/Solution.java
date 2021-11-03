package com.zhuangzhao.leetcode.weekly.contest.twozerozero.four;

class Solution {
    public int maxSum(int[] nums1, int[] nums2) {


        long total = 0;

        int i = 0;
        int j = 0;

        long total_01 = 0;
        long total_02 = 0;

        while (i < nums1.length || j < nums2.length) {
            if (i >= nums1.length) {
                total_02 += nums2[j];
                j++;
            } else if (j >= nums2.length) {
                total_01 += nums1[i];
                i++;
            } else {
                if (nums1[i] == nums2[j]) {
                    total += nums1[i];
                    if (total_01 > total_02) {
                        total += total_01;
                    } else {
                        total += total_02;
                    }
                    total %= (int) (Math.pow(10, 9) + 7);
                    total_01 = 0;
                    total_02 = 0;
                    i++;
                    j++;
                } else if (nums1[i] < nums2[j]) {
                    total_01 += nums1[i];
                    i++;
                } else {
                    total_02 += nums2[j];
                    j++;
                }
            }
            total %= (int) (Math.pow(10, 9) + 7);
        }
        if (total_01 > total_02) {
            total += total_01;
        } else {
            total += total_02;
        }
        total %= (int) (Math.pow(10, 9) + 7);
        return (int) total;

    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        int[] nums1 = {1, 3, 5, 7, 9};
        int[] nums2 = {3, 5, 100};

        System.out.println(solution.maxSum(nums1, nums2));
    }
}