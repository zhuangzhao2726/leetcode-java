package com.zhuangzhao.leetcode.eight;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

class Solution {
    public int myAtoi(String str) {


        String s = str.trim();

        if (s.length() == 0) {
            return 0;
        }

        int x = 0;
        if ('-' == s.charAt(0)) {
            x = -1;
        } else if ('+' == s.charAt(0)) {
            x = 1;
        }

        s = s.replaceAll("^[-+]", "");


        Pattern pattern = Pattern.compile("^(\\d+)");
        Matcher matcher = pattern.matcher(s);

        if (matcher.find()) {
            String value = matcher.group(1);

            value = value.replaceAll("^(0+)", "");


            if (value.length() > 15) {
                if (x == -1) {
                    return Integer.MIN_VALUE;
                } else {
                    return Integer.MAX_VALUE;
                }
            }
            if (value.length() == 0) {
                return 0;
            } else if (x == -1 && Long.valueOf(value) >= (1L << 31)) {
                return Integer.MIN_VALUE;
            } else if (x == -1) {
                return -1 * Integer.valueOf(value);
            } else if (Long.valueOf(value) >= (1L << 31)) {
                return Integer.MAX_VALUE;
            } else {
                return Integer.valueOf(value);
            }
        } else {
            return 0;
        }
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.myAtoi("   -42"));
    }
}