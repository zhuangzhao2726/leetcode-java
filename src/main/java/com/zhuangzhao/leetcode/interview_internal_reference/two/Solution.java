package com.zhuangzhao.leetcode.interview_internal_reference.two;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2020-10-04 20:30
 */
public class Solution {

    private static final double EPSINON = 0.0000000001;

    public double sqrt2() {
        double low = 1.0;
        double high = 2.0;
        while (high - low >= EPSINON) {
            double mid = low + (high - low) / 2;
            if (mid * mid > 2) {
                high = mid;
            } else {
                low = mid;
            }
        }
        return low;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.sqrt2());
    }
}
