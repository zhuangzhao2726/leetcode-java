package com.zhuangzhao.leetcode.interview.one.three.three;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2020-08-11 20:21
 */
public class Solution {

    private int minchaifen(int len, int m, int n) {
        if (len < m) {
            return 1;
        } else if (m <= n) {
            return -1;
        } else {
            return 1 + (int) Math.ceil((len - m) / (double) (m - n));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.minchaifen(10, 5, 2));
        System.out.println(solution.minchaifen(10, 4, 2));
        System.out.println(solution.minchaifen(10, 3, 2));
        System.out.println(solution.minchaifen(10, 2, 2));
        System.out.println(solution.minchaifen(10, 1, 2));
    }


}
