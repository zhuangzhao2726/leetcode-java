package com.zhuangzhao.leetcode.weekly.contest.twofourthree.two;

class Solution {
    public String maxValue(String n, int x) {
        int index = 0;
        if (n.charAt(0) == '-') {
            for (index = 1; index < n.length(); index++) {
                if (n.charAt(index) - '0' > x) {
                    break;
                }
            }
        } else {
            for (index = 0; index < n.length(); index++) {
                if (n.charAt(index) - '0' < x) {
                    break;
                }
            }
        }
        return n.substring(0, index) + x + (index < n.length() ? n.substring(index) : "");
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.maxValue("99", 9));
        System.out.println(solution.maxValue("97", 8));
        System.out.println(solution.maxValue("-13", 2));
    }
}