package com.zhuangzhao.leetcode.three.eight;

class Solution {

    public String countAndSay(int n) {
        return this.countAndSay1(n);
    }


    public String countAndSay1(int n) {
        if (n > 1) {
            String countAndSay = countAndSay(n - 1);
            StringBuilder builder = new StringBuilder();
            Character key = null;
            int count = 0;
            for (int i = 0; i <= countAndSay.length(); i++) {
                if (i == countAndSay.length() && key != null) {
                    builder.append(count);
                    builder.append(key);
                } else {
                    if (key == null) {
                        key = countAndSay.charAt(i);
                        count = 1;
                    } else if (key == countAndSay.charAt(i)) {
                        count++;
                    } else {
                        builder.append(count);
                        builder.append(key);
                        key = countAndSay.charAt(i);
                        count = 1;
                    }
                }
            }
            return builder.toString();
        } else if (n == 1) {
            return "1";
        } else {
            return "";
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        for (int i = 0; i < 10; i++) {
            System.out.println(solution.countAndSay(i));
        }
    }
}