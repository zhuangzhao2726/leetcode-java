package com.zhuangzhao.leetcode.lixi.binarysearch;

public class SolutionThree {
    public int searchInsert(int[] nums, int target) {
        int left = 0;
        int right = nums.length-1;
        int num;
        while(left<=right){
            int mid = left+(right-right)/2;
            if(target == mid){
                return mid;
            }else if(target>mid){
                left = mid+1;
            }else{
                right = mid-1;
            }
        }
        return left;
    }
}



