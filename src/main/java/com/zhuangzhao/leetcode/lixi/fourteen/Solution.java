package com.zhuangzhao.leetcode.lixi.fourteen;

class Solution {
    public String longestCommonPrefix(String[] strs) {
        if (strs == null || strs.length == 0) {
            return "";
        } else if (strs.length == 1) {
            return strs[0];
        }

        int index = 0;
        for (int i = 0; i < strs.length; i++) {
            if (i == 0) {
                index = strs[0].length();
            }
            if (index > strs[i].length()) {
                index = strs[i].length();
            }
        }

        for (int i = 0; i < index; i++) {
            char c = strs[0].charAt(i);
            for (int j = 1; j < strs.length; j++) {
                if (c != strs[j].charAt(i)) {
                    return strs[j].substring(0, i);
                }
            }

        }
        return strs[0].substring(0, index);
    }
}
