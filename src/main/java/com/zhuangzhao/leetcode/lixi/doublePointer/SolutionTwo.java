package com.zhuangzhao.leetcode.lixi.doublePointer;

public class SolutionTwo {
    public void rotate(int[] nums, int k) {
        //方法一：利用求余，新建一个数组
        int n = nums.length;
        int newArr[] = new int[n];
        for(int i = 0;i<n;i++){
            newArr[(i+k)%n]=nums[i];
        }
      System.arraycopy(newArr,0,nums,0,n);
    }
}
