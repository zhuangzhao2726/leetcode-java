package com.zhuangzhao.leetcode.lixi.demo3;

import java.util.HashSet;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2021-05-01 21:35
 */
public class Solution {


    public int minMoney(int[] arr) {
        if (arr == null || arr.length == 0) {
            return 0;
        }

        int length = arr.length;

        int[][] dp = new int[length][length];

        for (int i = 0; i < length; i++) {
            if(i == 0) {
                dp[i][i] = arr[i];
            } else {
                for (int j = 0; j < i; j++) {
                    int minTemp = Integer.MAX_VALUE;
                    for (int x = 0; x < i; x++) {
                        if(dp[j][x] == 0) {
                            continue;
                        } else {
                            int step = x > 0 ? 2 * x : 1;
                            if (j + step >= i) {
                                if (dp[j][x] < minTemp) {
                                    minTemp = dp[j][x];
                                }
                            }
                        }
                    }
                    if (minTemp < Integer.MAX_VALUE) {
                        dp[i][i - j] = minTemp + arr[i];
                    }
                }
            }
        }

        int minMoney = Integer.MAX_VALUE;
        for (int i = 0; i < length; i++) {
            if (dp[length - 1][i] > 0 && dp[length - 1][i] < minMoney) {
                minMoney = dp[length - 1][i];
            }
        }
        return minMoney;
    }


    public static void main(String[] args) {
//        Solution solution = new Solution();
//        int[] arr = {1,2,4,1,1,2,3};
//        System.out.println(solution.minMoney(arr));

        HashSet<Integer> set = new HashSet<>();
        set.add(1);
        set.add(1);
    }

}
