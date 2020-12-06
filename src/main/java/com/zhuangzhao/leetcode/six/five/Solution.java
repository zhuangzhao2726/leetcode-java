package com.zhuangzhao.leetcode.six.five;

import java.util.regex.Pattern;

class Solution {
    public boolean isNumber(String s) {
        String pattern = "^\\s*[+-]?((\\d+)|(\\.\\d+)|(\\d+)(\\.\\d*))(e([+-]?)\\d+)?\\s*$";
        return Pattern.matches(pattern, s);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        String[] array = {" +.8", " ", ".", "0"," 0.1 ", "-1234", "abc", "1 a", " -90e3 ", " 1e", "e3", " 6e-1", " 99e2.5 ", "53.5e93", " --6 ", "-+3", "95a54e53"};
        for (String str  : array) {
            System.out.println(str + "      " + solution.isNumber(str));
        }
    }
}