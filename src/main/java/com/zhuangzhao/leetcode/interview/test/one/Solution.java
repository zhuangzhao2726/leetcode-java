package com.zhuangzhao.leetcode.interview.test.one;

/**
 * 卖漫画书
 * @Author: zhuangzhao.zhu
 * @Date: 2020-10-18 19:27
 */
public class Solution {

    public int[] saleBookCounts(int n) {
        int[] counts = new int[n + 1];
        for (int i = n; i >= 0; i--) {
            if (i == n) {
                counts[i] = 4;
            } else {
                counts[i] = counts[i + 1] *2;
            }
        }
        return counts;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] counts = solution.saleBookCounts(6);
        for (int num : counts) {
            System.out.println(num);
        }
    }
}
