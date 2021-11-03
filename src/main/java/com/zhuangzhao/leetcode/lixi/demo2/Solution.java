package com.zhuangzhao.leetcode.lixi.demo2;

/**
 * @Author: zhuangzhao.zhu
 * @Date: 2021-05-01 21:22
 */
public class Solution {

    public int minMoney(int[] arr){
        if(arr == null){
            return 0;
        }

        int [] dp = new int[arr.length];
        for(int i = 0;i<arr.length;i++){
            if(i==0){
                dp[i] = arr[i];
            }else if(i==1){
                dp[i] = dp[i-1]+arr[i];
            }else{
                if(dp[i-1]<dp[i-2]){
                    dp[i] = dp[i-1]+arr[i];
                }else{
                    dp[i] = dp[i-2]+arr[i];
                }

            }
        }

        return dp[dp.length-1];
    }

    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1,9,2,3,9,1};
        int i = solution.minMoney(arr);
        System.out.println(i);

    }
}
