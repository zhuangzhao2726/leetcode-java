package com.zhuangzhao.leetcode.six.nine;

class Solution {
    public int mySqrt(int x) {
        return (int) Math.sqrt(x);
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.mySqrt(2147483647));
    }
}