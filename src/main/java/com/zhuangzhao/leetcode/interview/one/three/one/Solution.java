package com.zhuangzhao.leetcode.interview.one.three;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2020-08-11 19:07
 */
public class Solution {

    public Integer huiwenchuan(String str) {
        if (str == null || str.length() == 0) {
            return 0;
        }
        int left  = 0;
        int right = str.length() -1;
        int count = 0;
        while (left < right) {
            if (str.charAt(left++) != str.charAt(right--)) {
                count++;
            }
        }
        return count;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.huiwenchuan("1234567890"));
        System.out.println(solution.huiwenchuan("1234567890987654321"));
        System.out.println(solution.huiwenchuan(""));
        System.out.println(solution.huiwenchuan("1"));
        System.out.println(solution.huiwenchuan("123"));
    }
}
