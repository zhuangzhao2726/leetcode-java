package com.zhuangzhao.leetcode.lixi.bsweek01;

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
        return n.substring(0, index) + x + n.substring(index);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.maxValue("-13", 2));
    }
}