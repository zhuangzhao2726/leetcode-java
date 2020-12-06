package com.zhuangzhao.leetcode.offer.two;

class Solution {
    public String replaceSpace(String s) {
        return s.replaceAll(" ", "%20");
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.replaceSpace("We are happy."));
    }
}