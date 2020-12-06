package com.zhuangzhao.leetcode.one.four;

class Solution {
    public String longestCommonPrefix(String[] strs) {

        if (strs.length == 0) {
            return "";
        }

        String str = strs[0];
        int index = 0;
        boolean match = true;
        for (; index < str.length(); index++) {
            for (int i = 0; i < strs.length; i++) {
                if (i >= strs[i].length() || strs[i].charAt(index) != str.charAt(index)) {
                    match = false;
                }
            }
            if (!match) {
                break;
            }
        }
        return str.substring(0, index);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] strs = {"flower","flow","flight"};
        System.out.println(solution.longestCommonPrefix(strs));
    }
}