package com.zhuangzhao.leetcode.weekly.contest.twooneone.one;

class Solution {
    public int maxLengthBetweenEqualCharacters(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        int max = -1;
        for (int i = 0; i < s.length(); i++) {
            for (int j = s.length() - 1; j > i; j--) {
                if (s.charAt(i) == s.charAt(j)) {
                    if (j - i - 1 > max) {
                        max = j - i - 1;
                    }
                    break;
                }
            }
        }
        return max;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxLengthBetweenEqualCharacters("cbzxy"));
    }
}