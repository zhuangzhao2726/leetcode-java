package com.zhuangzhao.leetcode.one.two;

class Solution {
    public String intToRoman(int num) {

        StringBuffer buffer = new StringBuffer();
        buffer.append(transferThousand(num));
        buffer.append(transferHundred(num));
        buffer.append(transferTen(num));
        buffer.append(transferValue(num));
        return buffer.toString();
    }


    private String transferThousand(int num) {
        int value = num % 10000;
        value = value / 1000;

        switch (value) {
            case 0:
                return "";
            case 1:
                return "M";
            case 2:
                return "MM";
            case 3:
                return "MMM";
            default:
                return "";
        }
    }


    private String transferHundred(int num) {
        int value = num % 1000;
        value = value / 100;
        switch (value) {
            case 0:
                return "";
            case 1:
                return "C";
            case 2:
                return "CC";
            case 3:
                return "CCC";
            case 4:
                return "CD";
            case 5:
                return "D";
            case 6:
                return "DC";
            case 7:
                return "DCC";
            case 8:
                return "DCCC";
            case 9:
                return "CM";
            default:
                return "";
        }
    }


    private String transferTen(int num) {
        int value = num % 100;
        value = value / 10;
        switch (value) {
            case 0:
                return "";
            case 1:
                return "X";
            case 2:
                return "XX";
            case 3:
                return "XXX";
            case 4:
                return "XL";
            case 5:
                return "L";
            case 6:
                return "LX";
            case 7:
                return "LXX";
            case 8:
                return "LXXX";
            case 9:
                return "XC";
            default:
                return "";
        }
    }

    private String transferValue(int num) {
        int value = num % 10;

        switch (value) {
            case 0:
                return "";
            case 1:
                return "I";
            case 2:
                return "II";
            case 3:
                return "III";
            case 4:
                return "IV";
            case 5:
                return "V";
            case 6:
                return "VI";
            case 7:
                return "VII";
            case 8:
                return "VIII";
            case 9:
                return "IX";
            default:
                return "";
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.intToRoman(3));
        System.out.println(solution.intToRoman(1994));
    }
}
