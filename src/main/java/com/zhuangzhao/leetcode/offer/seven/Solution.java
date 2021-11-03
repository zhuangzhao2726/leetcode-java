package com.zhuangzhao.leetcode.offer.seven;

class Solution {
    public int minArray(int[] numbers) {
        return this.search(numbers, 0, numbers.length - 1);
    }

    private int search(int[] numbers, int start, int end) {
        if (start == end) {
            return numbers[start];
        }
        int mid = (end - start) / 2 + start;
        if (numbers[start] < numbers[start]) {
            return search(numbers, mid, end);
        } else if (numbers[start] > numbers[mid]) {
            return search(numbers, start, mid);
        } else {
            int a = search(numbers, start, mid);
            int b = search(numbers, mid + 1, end);
            return a < b ? a : b;
        }
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
//        int[] nums = {3,4,5,1,2};
        int[] nums = {2, 2, 2, 0, 1};
        System.out.println(solution.minArray(nums));
    }
}