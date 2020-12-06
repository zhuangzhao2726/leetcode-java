package com.zhuangzhao.leetcode.one.seven;

import java.util.ArrayList;
import java.util.List;

class Solution {


    public List<String> letterCombinations(String digits) {
        if (digits.isEmpty()) {
            return new ArrayList<>();
        }
        return letterCombinations(digits, "");
    }


    private  List<String> letterCombinations(String digits, String buffer) {

        List<String> result = new ArrayList<>();
        if (digits.isEmpty()) {
            result.add(buffer);
            return result;
        }
        char ch = digits.charAt(0);
        int total = (ch == '7' || ch == '9') ? 4 : 3;
        for (int i = 0; i < total; i++) {
            if (ch <= '7') {
                result.addAll(letterCombinations(digits.substring(1), buffer + (char)('a' + 3 * (ch - '2') + i)));
            } else {
                result.addAll(letterCombinations(digits.substring(1), buffer + (char)('t' + 3 * (ch - '8') + i)));
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.letterCombinations("7"));
    }
}