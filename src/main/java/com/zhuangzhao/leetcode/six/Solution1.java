package com.zhuangzhao.leetcode.six;

public class Solution1 {

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

        StringBuffer builder = new StringBuffer(s.length());

        int count = numRows + numRows - 2;
        int circle = s.length() / count;


        for (int i = 0; i < numRows; i++) {

            int first = -1 * count + i;
            int second = -1 * count + count - i;

            for (int j = 0; j < circle; j++) {
                first += count;
                second += count;
                builder.append(s.charAt(first));
                if (i > 0 && i < numRows - 1) {
                    builder.append(s.charAt(second));
                }
            }
            first += count;
            second += count;
            boolean flag = second < s.length();
            if (flag || first < s.length()) {
                builder.append(s.charAt(first));
            }
            if (i > 0 && i < numRows - 1 && flag) {
                builder.append(s.charAt(second));
            }
        }
        return builder.toString();
    }


    public static void main(String[] args) {
        Solution1 solution = new Solution1();
        System.out.println(solution.convert("PAYPALISHIRING", 3));
        System.out.println("PAHNAPLSIIGYIR".equalsIgnoreCase(solution.convert("PAYPALISHIRING", 3)));


        System.out.println(solution.convert("PAYPALISHIRING", 4));
        System.out.println("PINALSIGYAHRPI".equalsIgnoreCase(solution.convert("PAYPALISHIRING", 4)));
    }
}