package com.zhuangzhao.leetcode.six.six;

class Solution {
    public int[] plusOne(int[] digits) {
        if (needNewArray(digits)) {
            int[] newDigits = new int[digits.length + 1];
            newDigits[0] = 1;
            return newDigits;
        } else {
            int jinwei = 0;
            digits[digits.length - 1] = digits[digits.length - 1] + 1;
            for (int i = digits.length - 1; i >= 0; i--) {
                digits[i] = digits[i] + jinwei;
                if (digits[i] >= 10) {
                    digits[i] = digits[i] - 10;
                    jinwei = 1;
                } else {
                    break;
                }
            }
            return digits;
        }
    }

    private boolean needNewArray(int[] digits) {
        for (int num : digits) {
            if (num != 9) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] digits = {1, 2, 3, 4, 9, 9, 9};
        digits = solution.plusOne(digits);
        solution.print(digits);
    }

    private void print(int[] digits) {
        for (int num : digits) {
            System.out.print(num + "  ");
        }
    }
}