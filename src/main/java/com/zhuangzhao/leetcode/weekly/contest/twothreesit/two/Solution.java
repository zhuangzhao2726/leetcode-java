package com.zhuangzhao.leetcode.weekly.contest.twothreesit.two;

import java.util.ArrayList;
import java.util.List;

public class Solution {
    public int findTheWinner(int n, int k) {
        List<Integer> list = new ArrayList<>();
        for (int i = 1; i <= n; i++) {
            list.add(i);
        }
        int index = 0;
        while (list.size() > 1) {
            index = (index + k - 1) % list.size();
            list.remove(index);
        }
        return list.get(0);
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        System.out.println(solution.findTheWinner(5, 1));
        System.out.println(solution.findTheWinner(5, 2));
        System.out.println(solution.findTheWinner(6, 5));
    }
}