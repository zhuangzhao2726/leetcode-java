package com.zhuangzhao.leetcode.weekly.contest.twozerozero.one;

class Solution {
    public int countGoodTriplets(int[] arr, int a, int b, int c) {
        int total = 0;
        for (int i = 0; i < arr.length - 2; i++) {
            for (int j = i + 1; j < arr.length - 1; j++) {
                if (Math.abs(arr[i] - arr[j]) <= a) {
                    for (int k = j + 1; k < arr.length; k++) {
                        if (Math.abs(arr[j] - arr[k]) <= b && Math.abs(arr[i] - arr[k]) <= c) {
                            total++;
                        }

                    }
                }

            }
        }
        return total;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] arr = {3, 0, 1, 1, 9, 7};
        System.out.println(solution.countGoodTriplets(arr, 7, 2, 3));
    }
}