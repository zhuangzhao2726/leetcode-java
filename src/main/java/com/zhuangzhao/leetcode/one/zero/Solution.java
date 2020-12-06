package com.zhuangzhao.leetcode.one.zero;

class Solution {
    public boolean isMatch(String text, String pattern) {

        if (pattern.isEmpty()) {
            return text.isEmpty();
        }

        boolean firstMatch = (!text.isEmpty() && (text.charAt(0) == pattern.charAt(0) || pattern.charAt(0) == '.'));

        if (pattern.length() >= 2 && pattern.charAt(1) == '*') {
            return isMatch(text, pattern.substring(2)) || (firstMatch && isMatch(text.substring(1), pattern));
        } else {
            return firstMatch && isMatch(text.substring(1), pattern.substring(1));
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.isMatch("aa", ".*c"));
        System.out.println(solution.isMatch("aa", "a*"));
        System.out.println(solution.isMatch("ab", ".*"));
    }
}