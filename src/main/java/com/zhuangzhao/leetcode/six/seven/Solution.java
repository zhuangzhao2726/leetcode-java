package com.zhuangzhao.leetcode.six.seven;

class Solution {
    public String addBinary(String a, String b) {
        if (a == null || a.isEmpty()) {
            return b;
        }
        if (b == null || b.isEmpty()) {
            return a;
        }
        StringBuffer buffer = new StringBuffer();
        int len1 = a.length();
        int len2 = b.length();
        int max = len1 > len2 ? len1 : len2;

        int jinwei = 0;
        int value = 0;
        for (int i = 0; i < max; i++) {
            value = jinwei;
            if (i < len1) {
                value += a.charAt(len1 - 1 - i) - '0';
            }
            if (i < len2) {
                value += b.charAt(len2 - 1 - i) - '0';
            }
            jinwei = value >> 1;
            buffer.append(value & 1);
        }
        if (jinwei > 0) {
            buffer.append(jinwei);
        }
        return buffer.reverse().toString();
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.addBinary("111010111", "1"));
    }





}