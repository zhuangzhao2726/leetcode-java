package com.zhuangzhao.leetcode.interview.two;



class Solution {

    public Integer count(int[] arr) {
        int count  = 0;
        for (int value : arr) {
            count += (value / 2);
        }
        return count;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {1, 1, 1};
        System.out.println(solution.count(arr));

        int[] b = {5, 3, 7};
        System.out.println(solution.count(b));
    }
}