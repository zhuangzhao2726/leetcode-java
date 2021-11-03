package com.zhuangzhao.leetcode.weekly.contest.onenineeight.one;

class Solution {
    public int numWaterBottles(int numBottles, int numExchange) {
        int remainBottles = numBottles;
        int total = numBottles;
        while (remainBottles >= numExchange) {
            int count = remainBottles / numExchange;
            total += count;
            remainBottles = (remainBottles % numExchange) + count;
        }
        return total;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.numWaterBottles(15, 4));
        System.out.println(solution.numWaterBottles(5, 5));
        System.out.println(solution.numWaterBottles(2, 3));
        System.out.println(solution.numWaterBottles(3, 2));
    }
}