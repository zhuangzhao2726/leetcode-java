package com.zhuangzhao.leetcode.weekly.contest.onesixfive.two;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public List<Integer> numOfBurgers(int tomatoSlices, int cheeseSlices) {

        int smallNeedTomato = cheeseSlices * 2;
        int count = tomatoSlices - smallNeedTomato;

        List<Integer> result = new ArrayList<>();
        if (count >= 0 && count % 2 == 0 && count / 2 <= cheeseSlices) {
            int total_jumbo = count / 2;
            int total_small = cheeseSlices - total_jumbo;
            int[] array = new int[2];
            result.add(total_jumbo);
            result.add(total_small);
        }
        return result;
    }

    public static void main(String[] args) {
        Solution solution = new Solution();

        System.out.println(solution.numOfBurgers(16, 7));
        System.out.println(solution.numOfBurgers(17, 4));
        System.out.println(solution.numOfBurgers(4, 17));
        System.out.println(solution.numOfBurgers(0, 0));
        System.out.println(solution.numOfBurgers(2, 1));
    }
}