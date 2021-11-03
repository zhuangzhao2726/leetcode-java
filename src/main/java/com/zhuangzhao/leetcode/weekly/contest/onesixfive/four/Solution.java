package com.zhuangzhao.leetcode.weekly.contest.onesixfive.four;

import java.util.ArrayList;
import java.util.List;

class Solution {
    public int palindromePartition(String s, int k) {


        int[][] dp = new int[s.length() + 1][k + 1];

        List<List<String>> allResult = new ArrayList<>();


        for (int i = 1; i <= s.length(); i++) {
            for (int j = 1; j <= k; j++) {
                if (i == 1) {
                    dp[i][j] = 0;
                    continue;
                }
                if (j == 1) {
                    dp[i][j] = minStep(s, 0, i - 1);
                    continue;
                } else {
                    int min = Integer.MAX_VALUE;
                    for (int index = 1; index < i; index++) {
                        int count = dp[index][j - 1] + minStep(s, index, i - 1);
                        if (count < min) {
                            min = count;
                        }
                    }
                    dp[i][j] = min;
                }
            }
        }
        return dp[s.length()][k];
    }


    private int minStep(String s, int start, int end) {
        if (start >= s.length() || end >= s.length() || start >= end) {
            return 0;
        }
        int i = start;
        int j = end;
        int count = 0;
        while (i < j) {
            if (s.charAt(i) != s.charAt(j)) {
                count++;
            }
            i++;
            j--;
        }
        return count;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();

        String s = "abc";
        int k = 2;
        System.out.println(solution.palindromePartition(s, k));


        s = "aabbc";
        k = 3;
        System.out.println(solution.palindromePartition(s, k));


        s = "leetcode";
        k = 8;
        System.out.println(solution.palindromePartition(s, k));
    }
}