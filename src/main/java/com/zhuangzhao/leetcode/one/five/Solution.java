package com.zhuangzhao.leetcode.one.five;

import java.util.*;

class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        List<List<Integer>> results = new ArrayList<>();



        nums = sort(nums);

        for (int i = 0; i < nums.length && nums[i] <= 0; i++) {

            while (i > 0 && i < nums.length && nums[i] == nums[i - 1]) {
                i++;
            }
            if (i >= nums.length) {
                break;
            }

            int left = i + 1;
            int right = nums.length - 1;
            while (left < right) {
                if (nums[i] + nums[left] + nums[right] < 0) {
                    left++;
                    while (left < nums.length && nums[left] == nums[left-1]){
                        left++;
                    }
                } else if (nums[i] + nums[left] + nums[right] == 0) {
                    List<Integer> result = new ArrayList<>();
                    result.add(nums[i]);
                    result.add(nums[left]);
                    result.add(nums[right]);
                    results.add(result);
                    left++;
                    while (left < nums.length && nums[left] == nums[left-1]){
                        left++;
                    }
                    right--;
                    while (right > 0 && nums[right] == nums[right + 1]){
                        right--;
                    }
                } else {
                    right--;
                    while (right > 0 && nums[right] == nums[right + 1]){
                        right--;
                    }
                }
            }
        }
        return results;
    }



    private int[] sort(int[] nums) {
        for (int i = 0; i < nums.length; i++) {
            int min = i;
            for (int j = i + 1; j < nums.length; j++) {
                if (nums[j] < nums[min]) {
                    min = j;
                }
            }
            int value = nums[i];
            nums[i]= nums[min];
            nums[min] = value;
        }
        return nums;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] nums = {-1,0,1,2,-1,-4};
        System.out.println(solution.threeSum(nums));
    }
}