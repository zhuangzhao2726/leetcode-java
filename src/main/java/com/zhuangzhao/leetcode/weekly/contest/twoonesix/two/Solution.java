package com.zhuangzhao.leetcode.weekly.contest.twoonesix.two;

class Solution {
    public String getSmallestString(int n, int k) {
        int zCount = (k - n) / 25;
        int incr = (k - n) % 25;
        StringBuffer buffer = new StringBuffer("");
        for (int i = 0; i < n; i++) {
            if (i < n - zCount - 1) {
                buffer.append('a');
            } else if (i == n - zCount - 1) {
                buffer.append((char) ('a' + incr));
            } else {
                buffer.append("z");
            }
        }
        return buffer.toString();
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.getSmallestString(5, 73));
    }
}