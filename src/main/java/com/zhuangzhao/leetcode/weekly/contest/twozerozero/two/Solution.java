package com.zhuangzhao.leetcode.weekly.contest.twozerozero.two;

class Solution {
    public int getWinner(int[] arr, int k) {
        if (k >= arr.length - 1) {
            return this.max(arr);
        }
        int[] num = new int[arr.length];

        int max = -1;
        for (int i = 0; i < arr.length; i++) {
            int total = 0;
            if (max > 0 && max < arr[i]) {
                total++;
            }
            for (int j = i + 1; j < arr.length + i && arr[j % arr.length] < arr[i]; j++) {
                total++;
            }
            num[i] = total;
            if (arr[i] > max) {
                max = arr[i];
            }
        }

        for (int i = 0; i < num.length; i++) {
            if (num[i] >= k) {
                return arr[i];
            }
        }
        return 0;
    }

    private int max(int[] arr) {
        int max = 0;
        for (int value : arr) {
            if (value > max) {
                max = value;
            }
        }
        return max;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();


        int[] arr = {1, 9, 8, 2, 3, 7, 6, 4, 5};

        System.out.println(solution.getWinner(arr, 1));
        System.out.println(solution.getWinner(arr, 2));
        System.out.println(solution.getWinner(arr, 3));
        System.out.println(solution.getWinner(arr, 4));
        System.out.println(solution.getWinner(arr, 5));
        System.out.println(solution.getWinner(arr, 6));
        System.out.println(solution.getWinner(arr, 7));
        System.out.println(solution.getWinner(arr, 8));
        System.out.println(solution.getWinner(arr, 9));
    }
}