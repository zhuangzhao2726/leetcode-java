package com.zhuangzhao.leetcode.weekly.contest.twozeroone.two;

import java.util.Map;

class Solution {


    public char findKthBit(int n, int k) {
        String  s = this.generateString(n);
        return s.charAt(k - 1);
    }

    private String generateString(int n) {
        if ( n == 1) {
            return "0";
        } else {
            String str = this.generateString(n - 1);
            StringBuilder stringBuilder = new StringBuilder();
            stringBuilder.append(str);
            stringBuilder.append("1");
            for (int i = 0; i < str.length();i++) {
                if (str.charAt(str.length() - 1 - i) == '0') {
                    stringBuilder.append("1");
                } else {
                    stringBuilder.append("0");
                }
            }
            return stringBuilder.toString();
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findKthBit(3,1));
        System.out.println(solution.findKthBit(4,11));
        System.out.println(solution.findKthBit(1,1));
        System.out.println(solution.findKthBit(2,3));
    }
}