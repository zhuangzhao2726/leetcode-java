package com.zhuangzhao.leetcode.interview.one.three.two;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2020-08-11 19:14
 */
public class Solution {


    public Integer minColor(long length, long height) {
        if (length <= 0 || height <= 0) {
            return 0;
        }
        if (length * height == 1) {
            return 1;
        }

        long total = length * height;
        for (int i = 2; i <= total; i++) {
            if (total % i == 0) {
                return i;
            }
        }
        return 0;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minColor(1, 0));
        System.out.println(solution.minColor(3, 3));
        System.out.println(solution.minColor(5, 5));
        System.out.println(solution.minColor(37, 7));
    }
}
