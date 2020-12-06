package com.zhuangzhao.leetcode.five.eight;

class Solution {
    public int lengthOfLastWord(String s) {
        if (s == null || s.isEmpty()) {
            return 0;
        }
        String[] splits = s.split(" ");
        int length = 0;
        for (String str : splits) {
            length = str.length() > 0 ? str.length() : length;
        }
        return length;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.lengthOfLastWord("Hello World"));
    }
}