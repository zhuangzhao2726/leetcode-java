package com.zhuangzhao.leetcode.seven;

class Solution {
    public int reverse(int x) {
        String str = String.valueOf(x);

        long value = 0L;
        for (int i = str.length() - 1; i >= 0; i--) {
            value = value * 10 + Integer.valueOf(String.valueOf(str.charAt(i)));

        }
        if (value > Math.pow(2, 31))
            if (x < 0 && value > Math.pow(2, 31)) {
                return 0;
            } else if (x < 0) {
                return (int) (0 - value);
            }

        if (value >= Math.pow(2, 31)) {
            return 0;
        } else {
            return (int) value;
        }
    }
}