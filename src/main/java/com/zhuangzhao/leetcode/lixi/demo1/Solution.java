package com.zhuangzhao.leetcode.lixi.demo1;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2021-05-01 20:46
 */
public class Solution {
    public int maxMoney(int[][] martix) {
        //1、判断特殊情况
        if (martix == null || martix.length == 0 || martix[0].length == 0) {
            return 0;
        }
        //2、获取max(martix[i-1][j],martix[i][j-1])
        int[][] dp = new int[martix.length][martix[0].length];
        int maxtemp = 0;
        for (int i = 0; i < martix.length; i++) {
            for (int j = 0; j < martix[i].length; j++) {
                if (i == 0 && j == 0) {
                    maxtemp = 0;
                } else if (i == 0) {
                    maxtemp = dp[i][j - 1];
                } else if (j == 0) {
                    maxtemp = dp[i - 1][j];
                } else {
                    if (dp[i][j - 1] > dp[i - 1][j]) {
                        maxtemp = dp[i][j - 1];
                    } else {
                        maxtemp = dp[i - 1][j];
                    }
                }
                dp[i][j] = maxtemp + martix[i][j];
            }

        }
        return dp[martix.length - 1][martix[0].length - 1];

    }

    public static void main(String[] args) {
        int [][] martix = {{1,4,5,2},{2,2,1,3},{4,2,9,1},{1,2,3,4}};
        Solution solution = new Solution();
        int i = solution.maxMoney(martix);
        System.out.println(i);
    }
}
