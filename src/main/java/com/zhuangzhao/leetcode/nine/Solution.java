package com.zhuangzhao.leetcode.nine;

class Solution {
    public boolean isPalindrome(int x) {
        String s = String.valueOf(x);
        int length = s.length();
        for (int i =0; i< length/2; i++) {
            if (s.charAt(i) != s.charAt(length - 1 - i)) {
                return false;
            }
        }
        return true;
    }
}