package com.zhuangzhao.leetcode.weekly.contest.twozerozero.three;

class Solution {
    public int minSwaps(int[][] grid) {
        int[] num = new int[grid.length];
        for (int i = 0; i < grid.length; i++) {
            int count = 0;
            for (int j = grid.length - 1; j >= 0 && grid[grid.length -1  -i][j] == 0; j--) {
                count++;
            }
            num[i] = count;
        }

        if (!this.ckeckResult(num)) {
            return -1;
        } else {
            return this.sort(num);
        }
    }

    private int sort(int[] num) {
        int total = 0;

        for (int i = 0; i < num.length * num.length; i++) {
            boolean needUp = false;
            int index  = -1;
            for (int j = num.length - 1; j >= 0; j--) {
                if (!needUp && num[j] < j) {
                    needUp = true;
                    index = j;
                }
                if (needUp && num[j] >= index) {
                    int value = num[j];
                    num[j] = num[j+1];
                    num[j+1] = value;
                    total++;
                    break;
                }

            }
        }
        return total;
    }

    private boolean ckeckResult(int[] num) {
        int[] arr = new int[num.length];
        for (int i = 0; i < num.length; i++) {
            arr[i] = num[i];
        }


        for (int i = 0; i< arr.length; i++) {
            for (int j = 0; j < arr.length - i - 1; j++) {
                if (arr[j] > arr[j+1]) {
                    int value = arr[j];
                    arr[j] = arr[j+1];
                    arr[j + 1] = value;
                }
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] < i) {
                return false;
            }
        }
        return true;
    }


    public static void main(String[] args) {
        Solution solution = new Solution();
        int[][] grid = {{1,0,0},{1,1,0},{1,1,1}};
        System.out.println(solution.minSwaps(grid));
    }
}