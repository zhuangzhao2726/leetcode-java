package com.zhuangzhao.leetcode.one.three.five;

class Solution {
    public int candy(int[] ratings) {
        int[] count = new int[ratings.length];
        while (!suitable(ratings, count)) {
            for (int j = 0; j < count.length; j++) {
                if (count[j] == 0) {
                    count[j] = 1;
                }
                if (j > 0 && ratings[j -1] < ratings[j] && count[j - 1] >= count[j]) {
                    count[j] = count[j - 1] + 1;
                }
                if (j < count.length - 1 && ratings[j] > ratings[j + 1] && count[j + 1] >= count[j]) {
                    count[j] = count[j + 1] + 1;
                }
            }
        }
        int total = 0;
        for (int val : count) {
            total += val;
        }
        return total;
    }

    private boolean suitable(int[] ratings, int[] count) {
        for (int j = 0; j < count.length; j++) {
            if (count[j] == 0) {
                return false;
            }
            if (j > 0 && ratings[j -1] < ratings[j] && count[j - 1] >= count[j]) {
                return false;
            }
            if (j < count.length - 1 && ratings[j] > ratings[j + 1] && count[j + 1] >= count[j]) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[] ratings = {1,2,87,87,87,2,1};
        System.out.println(solution.candy(ratings));
    }
}