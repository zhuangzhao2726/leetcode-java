package com.zhuangzhao.leetcode.four.three;

class Solution {

    public String multiply(String num1, String num2) {
        StringBuilder result = new StringBuilder();
        for (int i = num2.length() - 1; i >= 0; i--) {
            String multiply = multiply(num1, num2.charAt(i) - '0');
            result = this.add(result.toString(), multiply, num2.length() - i - 1);
        }
        while (result.charAt(result.length() - 1) == '0' && result.length() > 1) {
            result.deleteCharAt(result.length() - 1);
        }
        return result.reverse().toString();
    }

    public String multiply(String num1, int num2) {
        StringBuilder builder = new StringBuilder();
        int jinwei = 0;
        for (int i = num1.length() - 1; i >= 0; i--) {
            int value = ((int) num1.charAt(i) - '0') * num2 + jinwei;
            builder.append(value % 10);
            jinwei = value / 10;
        }
        while (jinwei > 0) {
            builder.append(jinwei % 10);
            jinwei = jinwei / 10;
        }
        if (builder.length() == 0) {
            builder.append(0);
        }
        return builder.toString();
    }


    private StringBuilder add(String num1, String num2, int index) {
        StringBuilder builder = new StringBuilder();
        for (int i = 0; i < index; i++) {
            builder.append(num1.charAt(i));
        }
        int i = 0;
        int jinwei = 0;
        while (jinwei > 0 || i + index < num1.length() || i < num2.length()) {
            int value1 = i + index < num1.length() ? (num1.charAt(i + index) - '0') : 0;
            int value2 = i < num2.length() ? (num2.charAt(i) - '0') : 0;
            int value = value1 + value2 + jinwei;
            builder.append(value % 10);
            jinwei = value / 10;
            i++;
        }
        if (builder.length() == 0) {
            builder.append(0);
        }
        return builder;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.multiply("0", "11111"));
    }
}