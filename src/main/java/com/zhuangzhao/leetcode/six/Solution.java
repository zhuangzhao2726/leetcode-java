package com.zhuangzhao.leetcode.six;

public class Solution {

    /**
     * 分析
     * <p>
     * 长度为l的字符串，分为n行
     * <p>
     * 2 * n - 2 为一个循环
     * <p>
     * <p>
     * 第i行的数据：(2 * n - 2) * j + i (j < i)
     * 第i行的数据：(2 * n - 2) * j + (2 * n - 2) - i (j >= i)
     */
    public String convert(String s, int numRows) {


        if (s.length() == 0 || numRows == 1) {
            return s;
        }

        StringBuilder builder = new StringBuilder();

        for (int i = 0; i < numRows; i++) {
            for (int j = 0; j <= s.length() / (2 * numRows - 2); j++) {
                append(builder, s, numRows, i, j);
            }
            System.out.println();
        }
        return builder.toString();
    }

    private void append(StringBuilder builder, String s, int numRows, int i, int j) {
        int first = (2 * numRows - 2) * j + i;
        if (first < s.length()) {
            builder.append(s.charAt(first));

            //System.out.print(s.charAt(first));
        }
        int second = (2 * numRows - 2) * j + (2 * numRows - 2) - i;
        if (second >= (2 * numRows - 2) * j + numRows && second < (2 * numRows - 2) * (j + 1) && second < s.length()) {
            builder.append(s.charAt(second));

            //System.out.print(s.charAt(second));

        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.convert("PAYPALISHIRING", 3));
        System.out.println("PAHNAPLSIIGYIR".equalsIgnoreCase(solution.convert("PAYPALISHIRING", 3)));


        System.out.println(solution.convert("PAYPALISHIRING", 4));
        System.out.println("PINALSIGYAHRPI".equalsIgnoreCase(solution.convert("PAYPALISHIRING", 4)));
    }
}